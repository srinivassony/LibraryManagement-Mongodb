package com.libraryManagementMongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagementMongodb.dto.UserBookViewDTO;
import com.libraryManagementMongodb.model.UserCollection;

@Repository
public interface UserRepo extends MongoRepository<UserCollection, String> {

    Optional<UserCollection> findByEmail(String email);

    Page<UserCollection> findByRole(String role, org.springframework.data.domain.Pageable pageable);

    List<UserCollection> findUsersByEmail(List<String> emails);

    Optional<UserCollection> findByRollNo(String rollnumber);

    @Aggregation(pipeline = {
            "{ $match: { _id: ?0 } }",
            // Stage 1: Lookup lm_student_book to find borrowed books for the user
            "{ $lookup: { from: 'lm_student_book', localField: '_id', foreignField: 'user.$id', as: 'borrowedBooks' } }",

            // Stage 2: Unwind borrowedBooks array to get individual book records
            "{ $unwind: { path: '$borrowedBooks', preserveNullAndEmptyArrays: true } }",

            // Stage 3: Lookup lm_book to get book details
            "{ $lookup: { from: 'lm_book', localField: 'borrowedBooks.book.$id', foreignField: '_id', as: 'bookDetails' } }",

            // Stage 4: Unwind bookDetails array
            "{ $unwind: { path: '$bookDetails', preserveNullAndEmptyArrays: true } }",

            // Stage 5: Project the required fields
            "{ $project: { " +
                    "   id: '$_id', " +
                    "   userName: '$user_name', " +
                    "   email: 1, " +
                    "   userId: '$borrowedBooks.user.$id', " + // Extracting user ID from DBRef
                    "   bookId: '$bookDetails._id', " +
                    "   author: '$bookDetails.author', " +
                    "   bookName: '$bookDetails.book_name', " +
                    "   description: '$bookDetails.description', " +
                    "   noOfSets: '$bookDetails.no_of_sets', " +
                    "   submission_date: '$borrowedBooks.submission_date', " +
                    "   status: '$borrowedBooks.status' " +
                    "} }"
    })
    List<UserBookViewDTO> findUserBooksById(String id);

}
