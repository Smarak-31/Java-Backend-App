package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/getallcompanies")
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @PostMapping("/insertCompanies")
    public List<Company> createCompany(@RequestBody List<Company> company) {
        // System.out.println(company.getName() + " " + company.getLocation());
        return companyRepository.saveAll(company);
    }

    @Autowired
    private CompanyService companyService;

    // We use @PutMapping for updates
    @PutMapping("/update/{id}")
    public Company updateCompany(@PathVariable int id, @RequestParam String newName) {
        return companyService.updateCompanyName(id, newName);
    }

}
