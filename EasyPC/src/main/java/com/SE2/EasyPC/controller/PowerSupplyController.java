package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.PowerSupply;
import com.SE2.EasyPC.service.PowerSupplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PowerSupplyController {
     
    @Autowired
    PowerSupplyService powerSupplyService;

    @GetMapping("/power-supplies")
    public List<PowerSupply> getAllPowerSupplies() {
        return powerSupplyService.getAllPowerSupplies();
    }

    @GetMapping("/power-supply/{id}")
    public PowerSupply getPowerSupplyById(@PathVariable(value = "id") Long powerSupplyId) {
        return powerSupplyService.getPowerSupplyById(powerSupplyId);
    }

    @PostMapping("/power-supply")
    public PowerSupply createPowerSupply(@Valid @RequestBody PowerSupply powerSupply) {
        return powerSupplyService.createPowerSupply(powerSupply);
    }

    @DeleteMapping("/power-supply/{id}")
    public ResponseEntity<?> deletePowerSupply(@PathVariable(value = "id") Long powerSupplyId) {
        powerSupplyService.deletePowerSupply(powerSupplyId);
        return ResponseEntity.ok().build();
    }
}
