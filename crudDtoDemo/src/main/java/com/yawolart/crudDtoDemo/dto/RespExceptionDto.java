package com.yawolart.crudDtoDemo.dto;

import java.time.LocalDateTime;

public class RespExceptionDto {
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;


    public RespExceptionDto(LocalDateTime timestamp, int statusCode, String error, String message, String path) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public RespExceptionDto setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public RespExceptionDto setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getError() {
        return error;
    }

    public RespExceptionDto setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RespExceptionDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public RespExceptionDto setPath(String path) {
        this.path = path;
        return this;
    }
}
