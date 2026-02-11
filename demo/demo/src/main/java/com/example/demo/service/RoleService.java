package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Role updateRoleName(int id, String newRoleName) {
        // 1. Fetch the existing role
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        // 2. Update the field (Assuming your Role entity has a field called roleName or
        // title)
        // Make sure the setter name matches your Role.java entity field
        role.setRoleName(newRoleName);

        // 3. Return updated role (Automatic sync via @Transactional)
        return role;
    }
}