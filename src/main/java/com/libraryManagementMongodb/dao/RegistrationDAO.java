package com.libraryManagementMongodb.dao;

import java.util.Optional;

import com.libraryManagementMongodb.model.UserCollection;

public interface RegistrationDAO {

    Optional<UserCollection> isUserExists(String email);

    UserCollection createUser(UserCollection userDetails);
}
