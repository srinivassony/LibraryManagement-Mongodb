package com.libraryManagementMongodb.exceptions;

public class NoSuchApiException extends RuntimeException {
    public NoSuchApiException(String message) {
        super(message);
    }
}
