package com.yawolart.crudDtoDemo.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class RespValidationExceptionDto {
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String,String> fieldError;


    public RespValidationExceptionDto(LocalDateTime timestamp, int statusCode, String error, String message, String path, Map<String, String> fieldError) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldError = fieldError;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public RespValidationExceptionDto setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public RespValidationExceptionDto setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getError() {
        return error;
    }

    public RespValidationExceptionDto setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RespValidationExceptionDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public RespValidationExceptionDto setPath(String path) {
        this.path = path;
        return this;
    }

    public Map<String, String> getFieldError() {
        return fieldError;
    }

    public RespValidationExceptionDto setFieldError(Map<String, String> fieldError) {
        this.fieldError = fieldError;
        return this;
    }
}
