package com.myapp.guiderproject.exception;

public class ExceptionResponse {
    private String exceptionMessage;

    public ExceptionResponse(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}