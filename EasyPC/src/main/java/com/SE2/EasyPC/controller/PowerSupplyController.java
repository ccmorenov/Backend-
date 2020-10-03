package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.PowerSupply;
import com.SE2.EasyPC.service.PowerSupplyService;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PowerSupplyController {
     
    @Autowired
    PowerSupplyService powerSupplyService;

    @GetMapping("/power-supplies")
    public List<PowerSupply> getAllPowerSupplies(HttpServletRequest request ) {
        Log.createLog(0, "getAllPowerSupplies query received by " + request.getRemoteAddr());
        return powerSupplyService.getAllPowerSupplies();
    }

    @GetMapping("/power-supply/{id}")
    public PowerSupply getPowerSupplyById(@PathVariable(value = "id") Long powerSupplyId, HttpServletRequest request) {
        Log.createLog(0, "getPowerSupplyById query received by " + request.getRemoteAddr() );
        return powerSupplyService.getPowerSupplyById(powerSupplyId);
    }

    @PostMapping("/power-supply")
    public PowerSupply createPowerSupply(@Valid @RequestBody PowerSupply powerSupply, HttpServletRequest request) {
        Log.createLog(0, "createPowerSupply query received by " + request.getRemoteAddr() );
        return powerSupplyService.createPowerSupply(powerSupply);
    }

    @DeleteMapping("/power-supply/{id}")
    public ResponseEntity<?> deletePowerSupply(@PathVariable(value = "id") Long powerSupplyId, HttpServletRequest request) {
        Log.createLog(0, "deletePowerSupply query received by " + request.getRemoteAddr() );
        powerSupplyService.deletePowerSupply(powerSupplyId);
        return ResponseEntity.ok().build();
    }
}
