package com.Company.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Company.EmployeeManagementSystem.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
