package com.libraryManagementMongodb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "lm_user")
public class UserCollection {

    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "USER_NAME")
    private String userName;

    @Field(name = "EMAIL")
    private String email;

    @Field(name = "PASSWORD")
    private String password;

    @Field(name = "ROLE")
    private String role;

    @Field(name = "UUID")
    private String uuid;

    @Field(name = "PHONE")
    private String phone;

    @Field(name = "DOB")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dob;

    @Field(name = "ROLL_NO")
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

    public UserCollection() {
        this.uuid = java.util.UUID.randomUUID().toString(); // Generating UUID
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
