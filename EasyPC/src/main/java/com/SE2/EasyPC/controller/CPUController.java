package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.CPU;
import com.SE2.EasyPC.logging.Log;
import com.SE2.EasyPC.service.CPUService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CPUController {
    
    @Autowired
    CPUService cpuService;

    @GetMapping("/cpus")
    public List<CPU> getAllCPUs( HttpServletRequest request ) {
        Log.createLog(0, "getAllCPUs query received by " + request.getRemoteAddr());
        return cpuService.getAllCPUs();
    }

    @GetMapping("/cpu/{id}")
    public CPU getCPUById(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        Log.createLog(0, "getCPUById query received by " + request.getRemoteAddr());
        return cpuService.getCPUById(cpuId);
    }

    @PostMapping("/cpu")
    public CPU createCPU(@Valid @RequestBody CPU cpu, HttpServletRequest request ) {
        Log.createLog(0, "createCPU query received by " + request.getRemoteAddr());
        return cpuService.createCPU(cpu);
    }

    @DeleteMapping("/cpu/{id}")
    public ResponseEntity<?> deleteCPU(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        Log.createLog(0, "deleteCPU query received by " + request.getRemoteAddr());
        cpuService.deleteCPU(cpuId);
        return ResponseEntity.ok().build();
    }

}
