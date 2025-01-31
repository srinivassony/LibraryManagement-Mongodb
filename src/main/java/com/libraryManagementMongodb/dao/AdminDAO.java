package com.libraryManagementMongodb.dao;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import com.libraryManagementMongodb.model.UserCollection;

public interface AdminDAO {

    Page<UserCollection> getStudentRole(String role, Pageable pageable);

}
