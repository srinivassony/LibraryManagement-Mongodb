package com.libraryManagementMongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.libraryManagementMongodb.model.StudentBookCollection;

public interface StudentBookRepo extends MongoRepository<StudentBookCollection, String> {

    Optional<StudentBookCollection> findByBookIdAndUserId(String bookId, String userId);

}
