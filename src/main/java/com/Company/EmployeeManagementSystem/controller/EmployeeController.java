package com.Company.EmployeeManagementSystem.controller;

import com.Company.EmployeeManagementSystem.dto.CreateEmployeeDto;
import com.Company.EmployeeManagementSystem.dto.EmployeeResponseDto;
import com.Company.EmployeeManagementSystem.dto.SalaryIncrementDto;
import com.Company.EmployeeManagementSystem.dto.UpdateEmployeeRequestDto;
import com.Company.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Company.EmployeeManagementSystem.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody CreateEmployeeDto employee) {
        EmployeeResponseDto response = employeeService.registerEmployee(employee);
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(
                response
        );
    }
    @PutMapping({"/id"})
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@RequestBody UpdateEmployeeRequestDto updateEmployeeRequestDto,@PathVariable Long id){
        EmployeeResponseDto updatedEmployee  = employeeService.updateEmployee(updateEmployeeRequestDto,id);
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(
                updatedEmployee
        );
    }
    @GetMapping("/search/name")
    public ResponseEntity<List<Employee>> getEmployee(@RequestParam String name) {
        List<Employee> list = employeeService.searchEmployeeByName(name);
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(list);
    }

    @GetMapping("/search/salary")
    public ResponseEntity<List<Employee>> getEmployeeBySalary(@RequestParam BigDecimal minSalary,@RequestParam BigDecimal maxSalary) {
        List<Employee> list = employeeService.findBySalaryRange(minSalary,maxSalary);
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(list);

    }
    @PatchMapping("/{id}/salary")
    public ResponseEntity<EmployeeResponseDto> increaseSalary(@RequestBody SalaryIncrementDto percentage, @PathVariable String id) {
        EmployeeResponseDto response = employeeService.salaryIncrement(id,percentage);
    }
}
