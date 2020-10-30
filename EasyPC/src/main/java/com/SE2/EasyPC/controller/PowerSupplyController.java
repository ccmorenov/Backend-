package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.PowerSupply;
import com.SE2.EasyPC.service.PowerSupplyService;

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
public class PowerSupplyController {
    
    //declares corresponding service
    @Autowired
    PowerSupplyService powerSupplyService;

    //get http request for all power-supplies
    @GetMapping("/power-supplies")
    public List<PowerSupply> getAllPowerSupplies(HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return powerSupplyService.getAllPowerSupplies();
    }

    //get http request for power-supply by specific ID
    @GetMapping("/power-supply/{id}")
    public PowerSupply getPowerSupplyById(@PathVariable(value = "id") Long powerSupplyId, HttpServletRequest request) {
        //append to log

        //return the corresponding service logical function
        return powerSupplyService.getPowerSupplyById(powerSupplyId);
    }

    //Post http request for power-supply
    @PostMapping("/power-supply")
    //request body with object to post
    public PowerSupply createPowerSupply(@Valid @RequestBody PowerSupply powerSupply, HttpServletRequest request) {
        //append to log

        //return the corresponding service logical function
        return powerSupplyService.createPowerSupply(powerSupply);
    }

    //Delete http request for power-supply by ID
    @DeleteMapping("/power-supply/{id}")
    public ResponseEntity<?> deletePowerSupply(@PathVariable(value = "id") Long powerSupplyId, HttpServletRequest request) {
        //append to log

        //call the corresponding service logical function
        powerSupplyService.deletePowerSupply(powerSupplyId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
