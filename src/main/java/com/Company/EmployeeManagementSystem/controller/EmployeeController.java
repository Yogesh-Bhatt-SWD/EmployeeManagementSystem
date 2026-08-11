package com.Company.EmployeeManagementSystem.controller;

import com.Company.EmployeeManagementSystem.dto.CreateEmployeeDto;
import com.Company.EmployeeManagementSystem.dto.CreateResponseDto;
import com.Company.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Company.EmployeeManagementSystem.entity.Employee;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }
    public ResponseEntity<CreateResponseDto> createEmployee(@RequestBody CreateEmployeeDto employee) {
        CreateResponseDto response = employeeService.registerEmployee(employee);
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(
                response
        );
    }
}
