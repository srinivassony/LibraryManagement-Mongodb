package com.libraryManagementMongodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.libraryManagementMongodb.model.UserCollection;
import com.libraryManagementMongodb.repository.UserRepo;

@Service
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    UserRepo userRepo;

    @Override
    public Page<UserCollection> getStudentRole(String role, Pageable pageable) {
        // TODO Auto-generated method stub

        Page<UserCollection> user = userRepo.findByRole(role, pageable);
        if (!user.isEmpty()) {
            return user;
        } else {
            return Page.empty();
        }
    }
}
