package com.test.bank.bank.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class CreateUserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleException(SQLException exception){

        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
