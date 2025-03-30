package com.bookStore.bookStore.exception;

import org.springframework.http.HttpStatus;


public class UnauthorizedAccessException extends ApiException {
    public UnauthorizedAccessException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
