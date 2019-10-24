package com.example.controllers;

import com.example.exceptions.UniqueConstraintException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<Object> exceptionH(UniqueConstraintException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Status:", "409");
        errors.put("Error Message: ", String.valueOf(exception.getCause()));
        errors.put("Message: ", exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }
}

