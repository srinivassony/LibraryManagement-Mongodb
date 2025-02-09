package com.libraryManagementMongodb.utill;


import org.springframework.stereotype.Component;

import com.libraryManagementMongodb.dto.UserServiceDTO;
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
}
