package com.Company.EmployeeManagementSystem.service;

import com.Company.EmployeeManagementSystem.dto.CreateEmployeeDto;
import com.Company.EmployeeManagementSystem.dto.CreateResponseDto;
import com.Company.EmployeeManagementSystem.entity.Employee;
import com.Company.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
        public CreateResponseDto registerEmployee(CreateEmployeeDto employee) {
            Employee employee1 = new Employee();
            employee1.setName(employee.getName());
            employee1.setEmail(employee.getEmail());
            employee1.setAge(employee.getAge());
            employee1.setDepartment(employee.getDepartment());
            employee1.setSalary(employee.getSalary());

            Employee response = employeeRepository.save(employee1);

            CreateResponseDto savedStudent = mapToDto(response);
            return savedStudent;
        }

        private CreateResponseDto mapToDto(Employee response) {
            CreateResponseDto responseDto = new CreateResponseDto();

            responseDto.setId(response.getId());
            responseDto.setName(response.getName());
            responseDto.setEmail(response.getEmail());
            responseDto.setAge(response.getAge());
            responseDto.setSalary(response.getSalary());
            responseDto.setDepartment(response.getDepartment());
            return responseDto;
        }
}
