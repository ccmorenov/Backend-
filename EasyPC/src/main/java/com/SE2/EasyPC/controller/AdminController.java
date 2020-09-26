package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Admin;
import com.SE2.EasyPC.dataAccess.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AdminController {
    
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @PostMapping("/admin")
    public Admin createUser(@Valid @RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

}
