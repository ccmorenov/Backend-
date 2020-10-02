package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.CPU;
import com.SE2.EasyPC.service.CPUService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CPUController {
    
    @Autowired
    CPUService cpuService;

    @GetMapping("/cpus")
    public List<CPU> getAllCPUs() {
        return cpuService.getAllCPUs();
    }

    @GetMapping("/cpu/{id}")
    public CPU getCPUById(@PathVariable(value = "id") Long cpuId) {
        return cpuService.getCPUById(cpuId);
    }

    @PostMapping("/cpu")
    public CPU createCPU(@Valid @RequestBody CPU cpu) {
        return cpuService.createCPU(cpu);
    }

    @DeleteMapping("/cpu/{id}")
    public ResponseEntity<?> deleteCPU(@PathVariable(value = "id") Long cpuId) {
        cpuService.deleteCPU(cpuId);
        return ResponseEntity.ok().build();
    }

}
