package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.RAM;
import com.SE2.EasyPC.service.RAMService;

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
public class RAMController {
    
    //declares corresponding service
    @Autowired
    RAMService ramService;

    //get http request for all rams
    @GetMapping("/rams")
    public List<RAM> getAllRAMs(HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return ramService.getAllRAMs();
    }

    //get http request for ram by specific ID
    @GetMapping("/ram/{id}")
    public RAM getRAMById(@PathVariable(value = "id") Long ramId, HttpServletRequest request) {
        //append to log

        //return the corresponding service logical function
        return ramService.getRAMById(ramId);
    }

    //Post http request for ram
    @PostMapping("/ram")
    //request body with object to post
    public RAM createRAM(@Valid @RequestBody RAM ram, HttpServletRequest request) {
        //append to log

        //return the corresponding service logical function
        return ramService.createRAM(ram);
    }

    //Delete http request for ram by ID
    @DeleteMapping("/ram/{id}")
    public ResponseEntity<?> deleteRAM(@PathVariable(value = "id") Long ramId, HttpServletRequest request) {
        //append to log

        //call the corresponding service logical function
        ramService.deleteRAM(ramId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
