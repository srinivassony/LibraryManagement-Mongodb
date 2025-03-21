package com.libraryManagementMongodb.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;

import com.libraryManagementMongodb.dto.BookServiceDTO;
import com.libraryManagementMongodb.dto.UserBookViewDTO;
import com.libraryManagementMongodb.dto.UserInfoDTO;
import com.libraryManagementMongodb.dto.UserServiceDTO;
import com.libraryManagementMongodb.model.BookCollection;
import com.libraryManagementMongodb.model.StudentBookCollection;
import com.libraryManagementMongodb.model.UserCollection;

public interface AdminDAO {

    Page<UserCollection> getStudentRole(String role, Pageable pageable);

    UserServiceDTO updateUserInfo(String id, UserServiceDTO userServiceDTO, UserInfoDTO userDetails);

    Optional<UserCollection> deleteUserInfo(String id);

    List<UserCollection> getExisitingUsers(List<String> emails);

    List<UserCollection> uploadUserInfo(List<UserCollection> users);

    List<BookCollection> uploadBooks(List<BookCollection> books);

    BookServiceDTO updateBooksInfo(String id, BookServiceDTO bookServiceDTO);

    Optional<BookCollection> deleteBookInfo(String id);

    Optional<BookCollection> getBookById(String bookId);

    Optional<UserCollection> getUserByRollNumber(String rollNumber);

    BookCollection updateBookDetails(BookCollection bookEntity);

    StudentBookCollection createStudentBook(StudentBookCollection studentBook);

    public Optional<StudentBookCollection> checkBookAssigned(String bookId, String userId);

    List<UserBookViewDTO> getUserBooksById(String id);

    Map<String, Object> getUserBooksInfoByBookId(String id, int page, int size);

}
