package com.libraryManagementMongodb.dto;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceDTO {

    private String id;

    @Size(min = 2, max = 30, message = "Username must be between 2 and 50 characters")
    @NotBlank(message = "UserName is required!")
    @NotNull(message = "UserName must not be null.")
    private String userName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required!")
    @NotNull(message = "Email should not be null.")
    private String email;

    @NotBlank(message = "Password is required!")
    @NotNull(message = "Password should not be null.")
    private String password;

    private String role;

    private String uuid;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10// digits")
    private String phone;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dob;

    private String rollNo;

    private String country;

    private String state;

    private String gender;

    private LocalDateTime createdAt;

    private String createdBy;

    private Boolean isAdmin;

    private LocalDateTime updatedAt;

    private String updatedBy;

    public UserServiceDTO(String id, String userName, String email, String role, String country, String state,
            String dob, String phone, String rollNo, String gender, LocalDateTime createdAt, String createdBy,
            LocalDateTime updatedAt, String updatedBy) {

        this.id = id;
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.phone = phone;
        this.dob = dob;
        this.rollNo = rollNo;
        this.country = country;
        this.state = state;
        this.gender = gender;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

}
