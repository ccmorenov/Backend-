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

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdminController {
    
    //declares corresponding service
    @Autowired
    AdminService adminService;

    //get http request for all admins
    @GetMapping("/admins")
    public List<Admin> getAllAdmins( HttpServletRequest request ) {
        //append to log
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return adminService.getAllAdmins();
    }

    //get http request for admin by specific ID
    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(value = "id") Long adminId , HttpServletRequest request ) {
        //append to log
        Log.createLog(0, "getAdminById query received by " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return adminService.getAdminById(adminId);
    }

    //Post http request for admin
    @PostMapping("/admin")
    //request body with object to post
    public Admin createAdmin(@Valid @RequestBody Admin admin , HttpServletRequest request) {
        //append to log
        Log.createLog(0, "createAdmin query received by " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return adminService.createAdmin(admin);
    }

    //Delete http request for admin by ID
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long adminId , HttpServletRequest request) {
        //append to log
        Log.createLog(0, "deleteAdmin query received by " + request.getRemoteAddr() );
        //call the corresponding service logical function
        adminService.deleteAdmin(adminId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
