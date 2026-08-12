package com.Company.EmployeeManagementSystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class EmployeeResponseDto {
    private long id;

    private String name;

    private String email;

    private int age;

    private String department;

    private BigDecimal salary;
}
