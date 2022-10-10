package com.myapp.guiderproject.exception;

public class IncorrectRequestException extends RuntimeException {

    public IncorrectRequestException(String message) {
        super(message);
    }
}