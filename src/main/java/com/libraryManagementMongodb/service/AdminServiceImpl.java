package com.libraryManagementMongodb.service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.libraryManagementMongodb.config.CustomResponse;
import com.libraryManagementMongodb.dao.AdminDAO;
import com.libraryManagementMongodb.model.UserCollection;
import com.libraryManagementMongodb.utill.Utills;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;

    @Autowired
    Utills utills;

    @Override
    public ResponseEntity<?> getStudentRole(HttpServletRequest req, HttpServletResponse res, int page, int size) {

        try {

            String role = "ROLE_STUDENT,";

            Pageable pageable = PageRequest.of(page, size);

            Page<UserCollection> studentDataPage = adminDAO.getStudentRole(role, pageable);

            CustomResponse<?> responseBody = new CustomResponse<>(studentDataPage, "SUCCESS",
                    HttpStatus.OK.value(),
                    req.getRequestURI(), LocalDateTime.now());

            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch (Exception e) {

            CustomResponse<String> responseBody = new CustomResponse<>(e.getMessage(),
                    "BAD_REQUEST",
                    HttpStatus.BAD_REQUEST.value(), req.getRequestURI(), LocalDateTime.now());
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);

        }

    }

}
