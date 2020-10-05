package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.GPU;
import com.SE2.EasyPC.logging.Log;
import com.SE2.EasyPC.service.GPUService;

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
public class GPUController {
    
    //declares corresponding service
    @Autowired
    GPUService gpuService;

    //get http request for all gpus
    @GetMapping("/gpus")
    public List<GPU> getAllGPUs(HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getAllGPUs query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return gpuService.getAllGPUs();
    }

    //get http request for gpu by specific ID
    @GetMapping("/gpu/{id}")
    public GPU getGPUById(@PathVariable(value = "id") Long gpuId, HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getGPUById query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return gpuService.getGPUById(gpuId);
    }

    //Post http request for gpu
    @PostMapping("/gpu")
    //request body with object to post
    public GPU createGPU(@Valid @RequestBody GPU gpu, HttpServletRequest request) {
        //append to log
        Log.createLog(0, "createGPU query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return gpuService.createGPU(gpu);
    }

    //Delete http request for cpu by gpu
    @DeleteMapping("/gpu/{id}")
    public ResponseEntity<?> deleteGPU(@PathVariable(value = "id") Long gpuId, HttpServletRequest request) {
        //append to log
        Log.createLog(0, "deleteGPU query received by " + request.getRemoteAddr());
        //call the corresponding service logical function
        gpuService.deleteGPU(gpuId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
