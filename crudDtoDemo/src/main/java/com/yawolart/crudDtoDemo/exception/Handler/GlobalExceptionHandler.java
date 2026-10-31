package com.yawolart.crudDtoDemo.exception.Handler;

import com.yawolart.crudDtoDemo.exception.DuplicateEmailException;
import com.yawolart.crudDtoDemo.exception.ResourceNotFoundException;
import com.yawolart.crudDtoDemo.exception.UnableToUpdateDbException;
import com.yawolart.crudDtoDemo.dto.RespExceptionDto;
import com.yawolart.crudDtoDemo.dto.RespValidationExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RespExceptionDto> handleResourceNotFoundException(
            ResourceNotFoundException e,
            HttpServletRequest req)
    {
        RespExceptionDto respExceptionDto = new RespExceptionDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                req.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respExceptionDto);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<RespExceptionDto> handleDuplicateEmailException(
            DuplicateEmailException e,
            HttpServletRequest req)
    {
        RespExceptionDto respExceptionDto = new RespExceptionDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage(),
                req.getRequestURI()
        );
        return  ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(respExceptionDto);
    }

    @ExceptionHandler(UnableToUpdateDbException.class)
    public ResponseEntity<RespExceptionDto> handleUnableToUpdateDbException(
            UnableToUpdateDbException e,
            HttpServletRequest req)
    {
        RespExceptionDto respExceptionDto = new RespExceptionDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                e.getMessage(),
                req.getRequestURI()
        );
        return  ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(respExceptionDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespValidationExceptionDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e,
            HttpServletRequest req
    )
    {
        Map<String,String> fieldErrors = new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error ->
                        fieldErrors.put(error.getField(),error.getDefaultMessage()));
        RespValidationExceptionDto respValidationExceptionDto
                = new RespValidationExceptionDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_GATEWAY.getReasonPhrase(),
                "Input validation failed",
                req.getRequestURI(),
                fieldErrors
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respValidationExceptionDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RespExceptionDto> genericRuntimeException(
            RuntimeException e,
            HttpServletRequest req
    )
    {
        RespExceptionDto respExceptionDto = new RespExceptionDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Unknown runtime exception",
                req.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(respExceptionDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespExceptionDto> genericException(
            Exception e,
            HttpServletRequest req
    )
    {
        RespExceptionDto respExceptionDto = new RespExceptionDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Unknown exception",
                req.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(respExceptionDto);
    }


}
