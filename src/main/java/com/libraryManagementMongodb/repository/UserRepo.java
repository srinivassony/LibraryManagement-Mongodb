package com.libraryManagementMongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                        "{ $lookup: { from: 'lm_studentBook', localField: '_id', foreignField: 'user.$id', as: 'borrowedBooks' } }",

                        // Stage 2: Unwind borrowedBooks array to get individual book records
                        "{ $unwind: { path: '$borrowedBooks', preserveNullAndEmptyArrays: true } }",

                        // Stage 3: Lookup lm_book to get book details
                        "{ $lookup: { from: 'lm_book', localField: 'borrowedBooks.book.$id', foreignField: '_id', as: 'bookDetails' } }",

                        // Stage 4: Unwind bookDetails array
                        "{ $unwind: { path: '$bookDetails', preserveNullAndEmptyArrays: true } }",

                        // Stage 5: Project the required fields
                        "{ $project: { _id:'$_id',user_name:'$USER_NAME',email:'$EMAIL',status:'$borrowedBooks.STATUS',submission_date: '$borrowedBooks.SUBMISSION_DATE',bookId: '$bookDetails._id',author: '$bookDetails.AUTHOR',book_name: '$bookDetails.BOOK_NAME',description: '$bookDetails.DESCRIPTION', no_of_sets: '$bookDetails.NO_OF_SETS'} }"
        })
        List<UserBookViewDTO> findUserBooksById(String id);

        @Aggregation(pipeline = {
                        "{ $match: { $bookDetails._id: ?0 } }",
                        // Stage 1: Lookup lm_student_book to find borrowed books for the user
                        "{ $lookup: { from: 'lm_studentBook', localField: '_id', foreignField: 'user.$id', as: 'borrowedBooks' } }",

                        // Stage 2: Unwind borrowedBooks array to get individual book records
                        "{ $unwind: { path: '$borrowedBooks', preserveNullAndEmptyArrays: true } }",

                        // Stage 3: Lookup lm_book to get book details
                        "{ $lookup: { from: 'lm_book', localField: 'borrowedBooks.book.$id', foreignField: '_id', as: 'bookDetails' } }",

                        // Stage 4: Unwind bookDetails array
                        "{ $unwind: { path: '$bookDetails', preserveNullAndEmptyArrays: true } }",

                        // Stage 5: Project the required fields
                        "{ $project: { _id:'$_id',user_name:'$USER_NAME',email:'$EMAIL',status:'$borrowedBooks.STATUS',submission_date: '$borrowedBooks.SUBMISSION_DATE',bookId: '$bookDetails._id',author: '$bookDetails.AUTHOR',book_name: '$bookDetails.BOOK_NAME',description: '$bookDetails.DESCRIPTION', no_of_sets: '$bookDetails.NO_OF_SETS'} }"
        })
        List<UserBookViewDTO> findUserBooksByBookId(String id);

}
