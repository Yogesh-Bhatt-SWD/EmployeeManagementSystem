package com.Company.EmployeeManagementSystem.globalexceptionhandling;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String ex) {
        super(ex);
    }
}
