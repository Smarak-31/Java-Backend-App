package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee updateEmployee(int id, Employee employeeDetails) {
        // 1. Find the employee
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        // 2. Update fields
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setAge(employeeDetails.getAge());
        employee.setGender(employeeDetails.getGender());
        employee.setCompany(employeeDetails.getCompany());
        employee.setRole(employeeDetails.getRole());
        // 3. The change is automatically saved at the end of @Transactional
        return employee;
    }
}