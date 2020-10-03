package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Admin;
import com.SE2.EasyPC.dataAccess.repository.AdminRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    @Autowired
    AdminRepository adminRepository; 

    public List<Admin> getAllAdmins() {
        try{
            return adminRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllAdmins failed: " + e.getMessage() );
            throw e;
        }
    }

    public Admin getAdminById( Long id ) {
        try{
            return adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getAdminById failed: " + e.getMessage() );
            throw e;
        }
    }

    public Admin createAdmin(Admin admin) {
        try{
            return adminRepository.save(admin);
        }catch( Exception e ){
            Log.createLog(3, "Service createAdmin failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteAdmin( Long id ) {
        try{
            Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
            adminRepository.delete(admin);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteAdmin failed: " + e.getMessage() );
            throw e;
        }
    }
}
