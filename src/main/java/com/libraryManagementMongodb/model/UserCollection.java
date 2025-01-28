package com.libraryManagementMongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lm_user")
public class UserCollection {

     @Id
    private String id;

    
}
