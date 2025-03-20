package com.libraryManagementMongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagementMongodb.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/v2")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/get/all/books")
    @PreAuthorize("hasRole('ROLE_STUDENT')or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAllBooks(HttpServletRequest req,
            HttpServletResponse res,
            @RequestParam String searchKey) {
        return userService.getAllBooks(req, res, searchKey);
    }

}
