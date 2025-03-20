package com.libraryManagementMongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagementMongodb.model.BookCollection;

@Repository
public interface BookRepo extends MongoRepository<BookCollection, String> {

    @Aggregation(pipeline = {
            "{ $match: { $or: [ { 'author': { $regex: ?0, $options: 'i' } }, { 'bookName': { $regex: ?0, $options: 'i' } } ] } }"
    })

    List<Object[]> findBooksWithUserDetails(String searchKey);

}
