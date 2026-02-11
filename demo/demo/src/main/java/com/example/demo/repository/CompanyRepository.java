package com.example.demo.repository;

import com.example.demo.entity.Company; // Import your Entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
