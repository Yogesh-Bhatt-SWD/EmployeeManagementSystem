package com.Company.EmployeeManagementSystem.globalexceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> updateHandler(EmployeeNotFoundException ex) {
        return ResponseEntity.status(
                HttpStatus.NOT_FOUND
        ).body(ex.getMessage());
    }
    @ExceptionHandler(EmailAlreadyExistException.class)
        public ResponseEntity<String> isEmailExist(EmailAlreadyExistException ex){
            return ResponseEntity.status(
                    HttpStatus.CONFLICT
            ). body(ex.getMessage());
        }
    }

