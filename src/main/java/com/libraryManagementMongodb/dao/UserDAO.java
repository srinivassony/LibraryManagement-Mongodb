package com.libraryManagementMongodb.dao;

import java.util.List;

public interface UserDAO {

    List<Object[]> getAllBooks(String key);

}
