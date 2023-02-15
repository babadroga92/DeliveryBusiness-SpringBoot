package com.deliverybusiness.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class WrongIdException extends RuntimeException{
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public WrongIdException(String message) {
        super();
        this.message = message;
    }
}
