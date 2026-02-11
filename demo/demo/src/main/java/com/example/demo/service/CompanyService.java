package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public Company updateCompanyName(int id, String newName) {
        // 1. Find the company or throw an error if it doesn't exist
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));

        // 2. Modify the name (Hibernate "Dirty Checking" will detect this change)
        company.setCompanyName(newName);

        // 3. Return the updated object
        return company;
    }
}
