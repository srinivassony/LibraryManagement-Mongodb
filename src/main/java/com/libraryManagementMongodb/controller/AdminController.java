package com.libraryManagementMongodb.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.libraryManagementMongodb.dto.BookServiceDTO;
import com.libraryManagementMongodb.dto.StudentBookDTO;
import com.libraryManagementMongodb.dto.UserInfoDTO;
import com.libraryManagementMongodb.dto.UserServiceDTO;
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

    @PostMapping("/upload/bulk/books")
    public ResponseEntity<?> uploadBooksData(HttpServletRequest req,
            HttpServletResponse res,
            @RequestParam("file") MultipartFile file) {

        UserInfoDTO userDetails = (UserInfoDTO) req.getAttribute("user");

        return adminService.uploadBooksData(req, res, file, userDetails);
    }

    @PostMapping("/update/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateUserById(HttpServletRequest req,
            HttpServletResponse res, @PathVariable("id") String id, @RequestBody UserServiceDTO userServiceDTO) {
        UserInfoDTO userDetails = (UserInfoDTO) req.getAttribute("user");

        System.out.println("USER DETAILS" + " " + userDetails);
        return adminService.updateUserById(req, res, id, userServiceDTO, userDetails);
    }

    @DeleteMapping("/delete/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteUser(HttpServletRequest req, HttpServletResponse res,
            @PathVariable("id") String id) {

        return adminService.deleteUser(req, res, id);
    }

    @PostMapping("/upload/bulk/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> uploadUserData(HttpServletRequest req,
            HttpServletResponse res,
            @RequestParam("file") MultipartFile file) {
        UserInfoDTO userDetails = (UserInfoDTO) req.getAttribute("user");
        return adminService.uploadUsersData(req, res, file, userDetails);
    }

    @PostMapping("/update/books/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateBooksByBookId(HttpServletRequest req, HttpServletResponse res,
            @PathVariable("id") String id, @RequestBody BookServiceDTO bookServiceDTO) {

        return adminService.updateBooksByBookId(req, res, id, bookServiceDTO);
    }

    @DeleteMapping("/delete/book/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteBooksById(HttpServletRequest req, HttpServletResponse res,
            @PathVariable("id") String id) {

        return adminService.deleteBooksByBookId(req, res, id);
    }

    @PostMapping("/assign/book/user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> assignBookToUser(HttpServletRequest req, HttpServletResponse res,
            @RequestBody StudentBookDTO studentBookDTO) {

        return adminService.assignBookToUser(req, res, studentBookDTO);
    }

    @GetMapping("/get/user/books")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT')")
    public ResponseEntity<?> fetchUserBooksByUserId(HttpServletRequest req, HttpServletResponse res,
            @RequestParam String id) {

        return adminService.fetchUserBooksByUserId(req, res, id);
    }

    @GetMapping("/user/book/id")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> fetchUserBooksByBookId(HttpServletRequest req, HttpServletResponse res,
            @RequestBody BookServiceDTO bookServiceDTO, @RequestParam int page, @RequestParam int size) {

        return adminService.fetchUserBooksByBookId(req, res, bookServiceDTO, page, size);
    }

}
