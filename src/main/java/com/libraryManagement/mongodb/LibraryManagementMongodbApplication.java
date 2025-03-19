package com.libraryManagement.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class LibraryManagementMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementMongodbApplication.class, args);
		System.out.println("Application started!");
	}

}
