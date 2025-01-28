package com.libraryManagementMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagementMongodb.model.UserCollection;

@Repository
public interface UserRepo  extends MongoRepository<UserCollection, String> {

}
