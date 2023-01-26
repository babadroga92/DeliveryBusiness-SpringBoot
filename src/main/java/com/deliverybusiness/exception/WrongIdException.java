package com.deliverybusiness.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongIdException extends RuntimeException{
    private String message;

    public WrongIdException(String message) {
        super();
        this.message = message;
    }
}
