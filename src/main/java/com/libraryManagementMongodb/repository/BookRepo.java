package com.libraryManagementMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagementMongodb.model.BookCollection;

@Repository
public interface BookRepo extends MongoRepository<BookCollection, String> {

}
