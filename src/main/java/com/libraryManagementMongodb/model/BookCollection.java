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

@Document(collection = "lm_book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCollection {

    @Id
    @Indexed(unique = true)
    private String id = UUID.randomUUID().toString();

    @Field(name = "BOOK_NAME")
    private String bookName;

    @Field(name = "AUTHOR")
    private String author;

    @Field(name = "DESCRIPTION")
    private String description;

    @Field(name = "NO_OF_SETS")
    private Integer noOfSets;

    @Field(name = "CREATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Field(name = "CREATED_BY")
    private String createdBy;

    @Field(name = "UPDATED_AT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    @Field(name = "UPDATED_BY")
    private String updatedBy;

    // One-to-Many: A book can be borrowed multiple times
    @DBRef
    private List<StudentBookCollection> studentBooks;

}
