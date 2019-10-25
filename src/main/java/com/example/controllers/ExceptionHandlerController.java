package com.example.controllers;

import com.example.exceptions.UniqueConstraintException;
import com.example.responses.DefaultErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//globalny generyczny handler dla wyjatku unique costraint
//tworzymy customowa odpowiedz symulujaca slownik by zwrocic odpowiednia odpowiedz(JSON)
@ControllerAdvice
public class ExceptionHandlerController  {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<DefaultErrorResponse> exceptionH(UniqueConstraintException exception) {
        DefaultErrorResponse errors = new DefaultErrorResponse();
        errors.setError(exception.getMessage());
        errors.setStatus(HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }
}

