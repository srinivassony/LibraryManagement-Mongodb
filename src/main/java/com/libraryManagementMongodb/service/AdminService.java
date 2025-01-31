package com.libraryManagementMongodb.service;

import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AdminService {

    ResponseEntity<?> getStudentRole(HttpServletRequest req, HttpServletResponse res, int page, int size);

}
