package com.libraryManagementMongodb.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagementMongodb.model.UserCollection;
import com.libraryManagementMongodb.repository.UserRepo;

@Service
public class RegistrationDAOImpl implements RegistrationDAO {

    @Autowired
    UserRepo userRepo;

    @Override
    public Optional<UserCollection> isUserExists(String email) {

        return userRepo.findByEmail(email);

    }

    @Override
    public UserCollection createUser(UserCollection userDetails) {

        return userRepo.save(userDetails);
    }

}
