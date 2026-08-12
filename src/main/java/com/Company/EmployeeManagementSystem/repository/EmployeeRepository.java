package com.Company.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Company.EmployeeManagementSystem.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    boolean existsByEmail(String email);

    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findBySalaryBetween(BigDecimal minSalary,BigDecimal maxSalary);
}
