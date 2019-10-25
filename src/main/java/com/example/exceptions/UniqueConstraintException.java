package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//wyjatek dla unique constraint
@ResponseStatus(HttpStatus.CONFLICT)
public class UniqueConstraintException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UniqueConstraintException(String message) {
        super(message);
    }

    public UniqueConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}