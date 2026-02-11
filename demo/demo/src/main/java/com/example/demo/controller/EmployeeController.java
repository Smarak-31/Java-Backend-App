package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getallemployees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/insertemployees")
    public List<Employee> createEmployee(@RequestBody List<Employee> employee) {

        // System.out.println("Saving Employee: " + employee.getFirstName() + " " +
        // employee.getLastName());

        return employeeRepository.saveAll(employee);
    }

    @Autowired
    private EmployeeService employeeService;

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }
    // @PostMapping("/insertemployees")
    // public List<Employee> createEmployee(@RequestBody List<Employee> employees) {
    // // We must ensure Hibernate views the nested Company/Role as "existing"
    // for (Employee emp : employees) {
    // if (emp.getCompany() != null) {
    // // This creates a "proxy" that points to the existing ID in the DB
    // // Replace 'companyRepository' with your actual repository bean
    // //
    // emp.setCompany(companyRepository.getReferenceById(emp.getCompany().getId()));
    // }
    // if (emp.getRole() != null) {
    // // emp.setRole(roleRepository.getReferenceById(emp.getRole().getId()));
    // }
    // }
    // return employeeRepository.saveAll(employees);
    // }
}