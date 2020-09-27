package com.SE2.EasyPC.controller;


import com.SE2.EasyPC.dataAccess.model.Cooling;
import com.SE2.EasyPC.service.CoolingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CoolingController {
    
    @Autowired
    CoolingService coolingService;

    @GetMapping("/coolings")
    public List<Cooling> getAllCoolings() {
        return coolingService.getAllCoolings();
    }

    @GetMapping("/cooling/{id}")
    public Cooling getCoolingById(@PathVariable(value = "id") Long coolingId) {
        return coolingService.getCoolingById(coolingId);
    }

    @PostMapping("/cooling")
    public Cooling createCooling(@Valid @RequestBody Cooling cooling) {
        return coolingService.createCooling(cooling);
    }

    @DeleteMapping("/cooling/{id}")
    public ResponseEntity<?> deleteCooling(@PathVariable(value = "id") Long coolingId) {
        coolingService.deleteCooling(coolingId);
        return ResponseEntity.ok().build();
    }

}
