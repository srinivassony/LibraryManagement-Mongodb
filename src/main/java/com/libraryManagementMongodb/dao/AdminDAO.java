package com.libraryManagementMongodb.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;

import com.libraryManagementMongodb.model.UserCollection;

public interface AdminDAO {

    Page<UserCollection> getStudentRole(String role, Pageable pageable);

}
