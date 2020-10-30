package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Admin;
import com.SE2.EasyPC.dataAccess.repository.AdminRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for Admin, recives calls from AdminController and calls AdminRepository
@Service
public class AdminService {
    
    @Autowired
    AdminRepository adminRepository; 

    public List<Admin> getAllAdmins() { // returns a list with all Admins in the database
        try{
            return adminRepository.findAll();
        }catch( Exception e ){

            throw e;
        }
    }

    public Admin getAdminById( Long id ) { // returns the Admin with the requested ID or an exception if it does not exist
        try{
            return adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
        }catch( Exception e ){

            throw e;
        }
    }

    public Admin createAdmin(Admin admin) { // creates a new Admin in the database
        try{
            return adminRepository.save(admin);
        }catch( Exception e ){

            throw e;
        }
    }

    public void deleteAdmin( Long id ) { // deletes the Admin with the requested ID or an exception if it does not exist
        try{
            Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
            adminRepository.delete(admin);
        }catch( Exception e ){

            throw e;
        }
    }
}
