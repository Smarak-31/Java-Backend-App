package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/getallroles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @PostMapping("/insertRoles")
    public List<Role> createRole(@RequestBody List<Role> role) {
        // System.out.println(role.getName() + " " + role.getSalary());
        return roleRepository.saveAll(role);
    }

    @Autowired
    private RoleService roleService;

    @PutMapping("/update/{id}")
    public Role updateRole(@PathVariable int id, @RequestParam String newName) {
        return roleService.updateRoleName(id, newName);
    }
}
