package com.deliverybusiness.controller;

import com.deliverybusiness.exception.WrongIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;


@ControllerAdvice //global exception handler annotation
public class ExceptionMapper extends ResponseEntityExceptionHandler {
    private HashMap<String, String> convertException(String msg){
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("Error", msg);
        return mapa;
    }
    @ExceptionHandler({WrongIdException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public HashMap<String, String> handleWrongIdException(WrongIdException wrongIdException){
        return convertException(wrongIdException.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public HashMap<String,String> handleNullPointerException(NullPointerException nullPointerException){
        return convertException(nullPointerException.getMessage());
    }

}
