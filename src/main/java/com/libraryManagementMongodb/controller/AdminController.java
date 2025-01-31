package com.libraryManagementMongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagementMongodb.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v3")
public class AdminController {


    @Autowired
    AdminService adminService;

     @GetMapping("/get/student/role")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUserByRoles(HttpServletRequest req,
            HttpServletResponse res, @RequestParam int page, @RequestParam int size) {

        return adminService.getStudentRole(req, res, page, size);
    }
}
