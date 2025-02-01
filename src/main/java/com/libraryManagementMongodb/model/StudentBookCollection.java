package com.libraryManagementMongodb.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "lm_studentBook")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBookCollection {

    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "STATUS")
    private String status;

    @Field(name = "SUBMISSION_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime SubmissionDate;

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
}
