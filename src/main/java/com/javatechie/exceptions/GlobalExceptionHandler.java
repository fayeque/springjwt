package com.javatechie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler{
 
    @ExceptionHandler(value
                      = JwtTokenExpiredException.class)
    public ResponseEntity<Object> exception(JwtTokenExpiredException exception) {
       return new ResponseEntity<>("JWT token expired", HttpStatus.NOT_FOUND);
    }
}