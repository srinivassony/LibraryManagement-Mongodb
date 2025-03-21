package com.libraryManagementMongodb.utills;

import org.springframework.stereotype.Component;

import com.libraryManagementMongodb.dto.BookServiceDTO;
import com.libraryManagementMongodb.dto.UserServiceDTO;
import com.libraryManagementMongodb.model.BookCollection;
import com.libraryManagementMongodb.model.UserCollection;

@Component
public class UtillDTO {

    public UserServiceDTO convertToUserDTO(UserCollection userCollection) {
        return new UserServiceDTO(
                userCollection.getId(),
                userCollection.getUserName(),
                userCollection.getEmail(),
                userCollection.getRole(),
                userCollection.getCountry(),
                userCollection.getState(),
                userCollection.getDob(),
                userCollection.getPhone(),
                userCollection.getRollNo(),
                userCollection.getGender(),
                userCollection.getCreatedAt(),
                userCollection.getCreatedBy(),
                userCollection.getUpdatedAt(),
                userCollection.getUpdatedBy());
    }

    public BookServiceDTO convertToBookDTO(BookCollection bookEntity) {
        return new BookServiceDTO(
                bookEntity.getId(),
                bookEntity.getBookName(),
                bookEntity.getAuthor(),
                bookEntity.getDescription(),
                bookEntity.getNoOfSets(),
                bookEntity.getCreatedAt(),
                bookEntity.getCreatedBy(),
                bookEntity.getUpdatedAt(),
                bookEntity.getUpdatedBy());
    }
}
