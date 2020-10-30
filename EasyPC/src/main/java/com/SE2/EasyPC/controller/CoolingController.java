package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Cooling;
import com.SE2.EasyPC.service.CoolingService;

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
public class CoolingController {
    
    //declares corresponding service
    @Autowired
    CoolingService coolingService;

    //get http request for all coolings
    @GetMapping("/coolings")
    public List<Cooling> getAllCoolings( HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return coolingService.getAllCoolings();
    }

    //get http request for cooling by specific ID
    @GetMapping("/cooling/{id}")
    public Cooling getCoolingById(@PathVariable(value = "id") Long coolingId, HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return coolingService.getCoolingById(coolingId);
    }

    //Post http request for cooling
    @PostMapping("/cooling")
    //request body with object to post
    public Cooling createCooling(@Valid @RequestBody Cooling cooling, HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return coolingService.createCooling(cooling);
    }

    //Delete http request for cooling by ID
    @DeleteMapping("/cooling/{id}")
    public ResponseEntity<?> deleteCooling(@PathVariable(value = "id") Long coolingId, HttpServletRequest request ) {
        //append to log

        //call the corresponding service logical function
        coolingService.deleteCooling(coolingId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
