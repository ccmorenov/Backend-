package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Admin;
import com.SE2.EasyPC.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AdminController {
    
    @Autowired
    AdminService adminservice;

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminservice.getAllAdmins();
    }

    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(value = "id") Long adminId) {
        return adminservice.getAdminById(adminId);
    }

    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminservice.createAdmin(admin);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long adminId) {
        adminservice.deleteAdmin(adminId);
        return ResponseEntity.ok().build();
    }

}
