package com.libraryManagementMongodb.dto;

import java.time.LocalDateTime;

import com.libraryManagementMongodb.model.BookCollection;
import com.libraryManagementMongodb.model.UserCollection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBookDTO {

    private String id;

    private String status;

    private LocalDateTime SubmissionDate;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private UserCollection user;

    private BookCollection book;

    private String bookId;

    private String userId;

    private String rollNumber;

}
