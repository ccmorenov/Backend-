package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.CPU;
import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.service.CPUService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CPUController {

    private static final Logger logger = LogManager.getLogger();
    
    //declares corresponding service
    @Autowired
    CPUService cpuService;

    //get http request for all cpus
    @GetMapping("/cpus")
    public List<CPU> getAllCPUs( HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getAllCPUs();
    }

    //get http request for cpu by specific ID
    @GetMapping("/cpu/{id}")
    public CPU getCPUById(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getCPUById(cpuId);
    }

    //Post http request for cpu
    @PostMapping("/cpu")
    //request body with object to post
    public CPU createCPU(@Valid @RequestBody CPU cpu, HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.createCPU(cpu);
    }

    //Delete http request for cpu by ID
    @DeleteMapping("/cpu/{id}")
    public ResponseEntity<?> deleteCPU(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //call the corresponding service logical function
        cpuService.deleteCPU(cpuId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

    //get http request for compatible motheboards with cpu by specific cpu ID
    @GetMapping("/cpu/compatible/{id}")
    public List<Motherboard> getCompatibleMotherboardsById(@PathVariable(value = "id") Long cpuId, HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getCompatibleMotherboardsById(cpuId);
    }

    //post http request for compatible motheboards with cpu
    @PostMapping("/cpu/compatible")
    public List<Motherboard> getCompatibleMotherboards(@Valid @RequestBody CPU cpu, HttpServletRequest request ) {
        //append to log
        logger.trace( new Object(){}.getClass().getEnclosingMethod().getName() + " query at " + this.getClass().getSimpleName() + " from " + request.getRemoteAddr() );
        //return the corresponding service logical function
        return cpuService.getCPUById( cpu.getIdCPU() ).getCompatibleMotherboards();
    }

}
