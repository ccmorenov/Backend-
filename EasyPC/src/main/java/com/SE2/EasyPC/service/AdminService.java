package com.SE2.EasyPC.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.SE2.EasyPC.dataAccess.model.Admin;
import com.SE2.EasyPC.dataAccess.repository.AdminRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    @Autowired
    AdminRepository adminRepository; 

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById( Long id ) {
        return adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin( Long id ) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
        adminRepository.delete(admin);
    }

}
