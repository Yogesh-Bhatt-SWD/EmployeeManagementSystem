package com.Company.EmployeeManagementSystem.service;

import com.Company.EmployeeManagementSystem.dto.CreateEmployeeDto;
import com.Company.EmployeeManagementSystem.dto.EmployeeResponseDto;
import com.Company.EmployeeManagementSystem.dto.SalaryIncrementDto;
import com.Company.EmployeeManagementSystem.dto.UpdateEmployeeRequestDto;
import com.Company.EmployeeManagementSystem.entity.Employee;
import com.Company.EmployeeManagementSystem.globalexceptionhandling.EmailAlreadyExistException;
import com.Company.EmployeeManagementSystem.globalexceptionhandling.EmployeeNotFoundException;
import com.Company.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
        public EmployeeResponseDto registerEmployee(CreateEmployeeDto employee) {

            if(employeeRepository.existsByEmail(employee.getEmail())) {
                throw new EmailAlreadyExistException("Employee with this email "+employee.getEmail()+ " already exist");
            }
            Employee employee1 = new Employee();
            employee1.setName(employee.getName());
            employee1.setEmail(employee.getEmail());
            employee1.setAge(employee.getAge());
            employee1.setDepartment(employee.getDepartment());
            employee1.setSalary(employee.getSalary());

            Employee response = employeeRepository.save(employee1);

            EmployeeResponseDto savedStudent = mapToDto(response);
            return savedStudent;
        }
        public EmployeeResponseDto updateEmployee(UpdateEmployeeRequestDto requestDto,Long id) {
            Employee existEmployee = employeeRepository.findById(id).
                    orElseThrow(()-> new EmployeeNotFoundException("Employee with this id "+id+" not found"));
            existEmployee.setName(requestDto.getName());
            existEmployee.setSalary(requestDto.getSalary());
            existEmployee.setAge(requestDto.getAge());

            employeeRepository.save(existEmployee);

            return mapToUpdateDto(existEmployee);
        }

        public List<Employee> searchEmployeeByName(String name) {
            return employeeRepository.findByNameContainingIgnoreCase(name);
        }

        public List<Employee> findBySalaryRange(BigDecimal minSalary,BigDecimal maxSalary) {
            return employeeRepository.findBySalaryBetween(minSalary,maxSalary);
        }

//        public EmployeeResponseDto salaryIncrement(Long id,SalaryIncrementDto percentage) {
//            Employee existingEmployee = employeeRepository.findById(id).
//                    orElseThrow(()-> new EmployeeNotFoundException("Employee with this id "+id+" not found"));
//
//            BigDecimal salary = existingEmployee.getSalary();
//        }

        private EmployeeResponseDto mapToDto(Employee response) {
            EmployeeResponseDto responseDto = new EmployeeResponseDto();

            responseDto.setId(response.getId());
            responseDto.setName(response.getName());
            responseDto.setEmail(response.getEmail());
            responseDto.setAge(response.getAge());
            responseDto.setSalary(response.getSalary());
            responseDto.setDepartment(response.getDepartment());
            return responseDto;
        }
        private EmployeeResponseDto mapToUpdateDto(Employee existEmployee) {
            EmployeeResponseDto update = new EmployeeResponseDto();
            update.setId(existEmployee.getId());
            update.setName(existEmployee.getName());
            update.setAge(existEmployee.getAge());
            update.setSalary(existEmployee.getSalary());
            update.setDepartment(existEmployee.getDepartment());
            return update;
        }

}
