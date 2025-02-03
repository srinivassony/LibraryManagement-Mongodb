package com.libraryManagementMongodb.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.libraryManagementMongodb.dto.UserInfoDTO;
import com.libraryManagementMongodb.dto.UserServiceDTO;
import com.libraryManagementMongodb.model.BookCollection;
import com.libraryManagementMongodb.model.UserCollection;
import com.libraryManagementMongodb.repository.BookRepo;
import com.libraryManagementMongodb.repository.UserRepo;
import com.libraryManagementMongodb.utill.UtillDTO;

@Service
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    UtillDTO utillDTO;

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

    // @Override
    // public List<BookCollection> uploadBooks(List<BookCollection> books) {
    // // TODO Auto-generated method stub

    // if (books != null && !books.isEmpty()) {
    // // Save the users to the database
    // List<BookCollection> savedUsers = bookRepo.saveAll(books);
    // return savedUsers; // Return the saved users list
    // } else {
    // // If the list is empty or null, you can handle accordingly (e.g., return an
    // // empty list)
    // return new ArrayList<>();
    // }
    // }

    @Override
    public UserServiceDTO updateUserInfo(String id, UserServiceDTO userServiceDTO, UserInfoDTO userDetails){

        // ObjectId objectId;

        // try {
        //     objectId = new ObjectId(id); // Convert String to ObjectId
        // } catch (IllegalArgumentException e) {
        //     throw new BadRequestException("Invalid ObjectId format: " + id);
        // }
        System.out.println("Converted ObjectId: " + id);
        return userRepo.findById(id)
                .map(entity -> {
                    // Update other fields as needed

                    System.out.println("✅ User found in DB: " + entity);

                    if (userServiceDTO.getUserName() != null) {
                        entity.setUserName(userServiceDTO.getUserName());
                    }

                    if (userServiceDTO.getEmail() != null) {
                        entity.setEmail(userServiceDTO.getEmail());
                    }

                    if (userServiceDTO.getPhone() != null) {
                        entity.setPhone(userServiceDTO.getPhone());
                    }

                    if (userServiceDTO.getCountry() != null) {
                        entity.setCountry(userServiceDTO.getCountry());
                    }

                    if (userServiceDTO.getState() != null) {
                        entity.setState(userServiceDTO.getState());
                    }

                    if (userServiceDTO.getDob() != null) {
                        entity.setDob(userServiceDTO.getDob());
                    }

                    if (userServiceDTO.getGender() != null) {
                        entity.setGender(userServiceDTO.getGender());
                    }

                    entity.setUpdatedAt(LocalDateTime.now());
                    entity.setUpdatedBy(userDetails.getUuid());

                    UserCollection userCollection = userRepo.save(entity);
                    return utillDTO.convertToUserDTO(userCollection);

                }).orElseThrow(() -> new UsernameNotFoundException("User not found with id "
                        + id));
    }

    // @Override
    // public Optional<UserCollection> deleteUserInfo(String id) {
    //     Optional<UserCollection> user = userRepo.findById(id);
    //     if (user.isPresent()) {
    //         // Delete the user entity
    //         userRepo.deleteById(id);
    //         return user;
    //     } else {
    //         return Optional.empty();
    //     }
    // }

    @Override
    public List<UserCollection> getExisitingUsers(List<String> emails) {

        List<UserCollection> users = userRepo.findUsersByEmail(emails);

        return users;

    }

    @Override
    public List<UserCollection> uploadUserInfo(List<UserCollection> users) {

        if (users != null && !users.isEmpty()) {
            // Save the users to the database
            List<UserCollection> savedUsers = userRepo.saveAll(users);
            return savedUsers; // Return the saved users list
        } else {
            // If the list is empty or null, you can handle accordingly (e.g., return an
            // empty list)
            return new ArrayList<>();
        }
    }
}
