package com.libraryManagementMongodb.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.libraryManagementMongodb.model.UserCollection;

@Repository
public interface UserRepo extends MongoRepository<UserCollection, String> {

    Optional<UserCollection> findByEmail(String email);

    Page<UserCollection> findByRole(String role, org.springframework.data.domain.Pageable pageable);

    List<UserCollection> findUsersByEmail(List<String> emails);

}
