package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Admin;
import com.SE2.EasyPC.logging.Log;
import com.SE2.EasyPC.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdminController {
    
    @Autowired
    AdminService adminService;

    @GetMapping("/admins")
    public List<Admin> getAllAdmins( HttpServletRequest request ) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        return adminService.getAllAdmins();
    }

    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(value = "id") Long adminId , HttpServletRequest request ) {
        Log.createLog(0, "getAdminById query received by " + request.getRemoteAddr() );
        return adminService.getAdminById(adminId);
    }

    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin , HttpServletRequest request) {
        Log.createLog(0, "createAdmin query received by " + request.getRemoteAddr() );
        return adminService.createAdmin(admin);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long adminId , HttpServletRequest request) {
        Log.createLog(0, "deleteAdmin query received by " + request.getRemoteAddr() );
        adminService.deleteAdmin(adminId);
        return ResponseEntity.ok().build();
    }
}
