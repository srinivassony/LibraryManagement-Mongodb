package com.libraryManagement.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.libraryManagementMongodb")
@EnableMongoRepositories(basePackages = "com.libraryManagementMongodb.repository")
public class LibraryManagementMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementMongodbApplication.class, args);
		System.out.println("Application started!");
	}

}
