package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee", schema = "schema1")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    // @ManyToOne(cascade = CascadeType.MERGE)
    // @JoinColumn(name = "company_id")
    private int company_id;

    // @ManyToOne(cascade = CascadeType.MERGE)
    // @JoinColumn(name = "role_id")
    private int role_id;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCompany() {
        return company_id;
    }

    public void setCompany(int company_id) {
        this.company_id = company_id;
    }

    public int getRole() {
        return role_id;
    }

    public void setRole(int role_id) {
        this.role_id = role_id;
    }
}