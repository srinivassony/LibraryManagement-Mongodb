package com.libraryManagementMongodb.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "lm_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCollection {

    @Id
    @Indexed(unique = true)
    private String id = UUID.randomUUID().toString();

    @Field(name = "USER_NAME")
    private String userName;

    @Field(name = "EMAIL")
    @Indexed(unique = true)
    private String email;

    @Field(name = "PASSWORD")
    private String password;

    @Field(name = "ROLE")
    private String role;

    @Field(name = "UUID")
    @Indexed(unique = true)
    private String uuid;

    @Field(name = "PHONE")
    private String phone;

    @Field(name = "DOB")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dob;

    @Field(name = "ROLL_NO")
    @Indexed(unique = true)
    private String rollNo;

    @Field(name = "COUNTRY")
    private String country;

    @Field(name = "STATE")
    private String state;

    @Field(name = "GENDER")
    private String gender;

    @Field(name = "CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Field(name = "CREATED_BY")
    private String createdBy;

    @Field(name = "UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    @Field(name = "UPDATED_BY")
    private String updatedBy;

    @DBRef
    private List<StudentBookCollection> studentBooks;

}
