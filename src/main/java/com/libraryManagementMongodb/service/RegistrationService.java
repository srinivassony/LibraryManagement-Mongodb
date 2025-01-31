package com.libraryManagementMongodb.service;

import org.springframework.http.ResponseEntity;

import com.libraryManagementMongodb.dto.UserServiceDTO;
import com.libraryManagementMongodb.model.UserCollection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

public interface RegistrationService {

    ResponseEntity<?> createUserInfo(UserServiceDTO userServiceDTO, HttpServletRequest req,
            HttpServletResponse res);

    ResponseEntity<?> authenticateUser(UserCollection userCollection, HttpServletRequest req, HttpServletResponse res);

}
