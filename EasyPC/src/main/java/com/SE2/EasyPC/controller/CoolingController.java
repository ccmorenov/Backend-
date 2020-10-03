package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Cooling;
import com.SE2.EasyPC.logging.Log;
import com.SE2.EasyPC.service.CoolingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CoolingController {
    
    @Autowired
    CoolingService coolingService;

    @GetMapping("/coolings")
    public List<Cooling> getAllCoolings( HttpServletRequest request ) {
        Log.createLog(0, "getAllCoolings query received by " + request.getRemoteAddr());
        return coolingService.getAllCoolings();
    }

    @GetMapping("/cooling/{id}")
    public Cooling getCoolingById(@PathVariable(value = "id") Long coolingId, HttpServletRequest request ) {
        Log.createLog(0, "getCoolingById query received by " + request.getRemoteAddr());
        return coolingService.getCoolingById(coolingId);
    }

    @PostMapping("/cooling")
    public Cooling createCooling(@Valid @RequestBody Cooling cooling, HttpServletRequest request ) {
        Log.createLog(0, "createCooling query received by " + request.getRemoteAddr());
        return coolingService.createCooling(cooling);
    }

    @DeleteMapping("/cooling/{id}")
    public ResponseEntity<?> deleteCooling(@PathVariable(value = "id") Long coolingId, HttpServletRequest request ) {
        Log.createLog(0, "deleteCooling query received by " + request.getRemoteAddr());
        coolingService.deleteCooling(coolingId);
        return ResponseEntity.ok().build();
    }

}
