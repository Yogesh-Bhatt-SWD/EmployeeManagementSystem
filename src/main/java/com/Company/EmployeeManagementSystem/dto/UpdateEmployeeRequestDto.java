package com.Company.EmployeeManagementSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeRequestDto {
    private String name;
    private int age;
    private int salary;

}
