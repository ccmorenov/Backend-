package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.service.MotherboardService;
import com.SE2.EasyPC.logging.Log;

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
public class MotherboardController {
    
    //declares corresponding service
    @Autowired
    MotherboardService motherboardService;

    //get http request for all motherboards
    @GetMapping("/motherboards")
    public List<Motherboard> getAllMotherboards(HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return motherboardService.getAllMotherboards();
    }

    //get http request for motherboard by specific ID
    @GetMapping("/motherboard/{id}")
    public Motherboard getMotherboardById(@PathVariable(value = "id") Long motherboardId,HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return motherboardService.getMotherboardById(motherboardId);
    }

    //Post http request for motherboard
    @PostMapping("/motherboard")
    //request body with object to post
    public Motherboard createMotherboard(@Valid @RequestBody Motherboard motherboard,HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return motherboardService.createMotherboard(motherboard);
    }

    //Delete http request for motherboard by ID
    @DeleteMapping("/motherboard/{id}")
    public ResponseEntity<?> deleteMotherboard(@PathVariable(value = "id") Long motherboardId,HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        //call the corresponding service logical function
        motherboardService.deleteMotherboard(motherboardId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
