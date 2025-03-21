package com.libraryManagementMongodb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @PostMapping("/add/user")
    public ResponseEntity<?> createUser() {
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

}
