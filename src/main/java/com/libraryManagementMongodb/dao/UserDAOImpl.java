package com.libraryManagementMongodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagementMongodb.repository.BookRepo;

@Service
public class UserDAOImpl implements UserDAO {

    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Object[]> getAllBooks(String searchKey) {
        // TODO Auto-generated method stub

        return bookRepo.findBooksWithUserDetails(searchKey);

    }

}
