package com.in28minutes.rest.webservices.restfullwebservices.exception;

public class ApiFieldError {
    private String propertyPath;
    private String message;

    public ApiFieldError(String propertyPath, String message) {
        this.propertyPath = propertyPath;
        this.message = message;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public String getMessage() {
        return message;
    }

}
