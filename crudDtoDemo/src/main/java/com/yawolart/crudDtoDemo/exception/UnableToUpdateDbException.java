package com.yawolart.crudDtoDemo.exception;

public class UnableToUpdateDbException extends RuntimeException{
    public UnableToUpdateDbException(String message) {
        super(message);
    }
}
