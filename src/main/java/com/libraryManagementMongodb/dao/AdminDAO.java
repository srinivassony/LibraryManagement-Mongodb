package com.libraryManagementMongodb.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;

import com.libraryManagementMongodb.dto.UserInfoDTO;
import com.libraryManagementMongodb.dto.UserServiceDTO;
import com.libraryManagementMongodb.model.BookCollection;
import com.libraryManagementMongodb.model.UserCollection;

public interface AdminDAO {

    Page<UserCollection> getStudentRole(String role, Pageable pageable);

    UserServiceDTO updateUserInfo(String id, UserServiceDTO userServiceDTO, UserInfoDTO userDetails);

    // Optional<UserCollection> deleteUserInfo(String id);

    List<UserCollection> getExisitingUsers(List<String> emails);

    List<UserCollection> uploadUserInfo(List<UserCollection> users);

    List<BookCollection> uploadBooks(List<BookCollection> books);

}
