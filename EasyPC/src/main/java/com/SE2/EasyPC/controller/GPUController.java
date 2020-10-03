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

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GPUController {
    
    @Autowired
    GPUService gpuService;

    @GetMapping("/gpus")
    public List<GPU> getAllGPUs(HttpServletRequest request) {
        Log.createLog(0, "getAllGPUs query received by " + request.getRemoteAddr());
        return gpuService.getAllGPUs();
    }

    @GetMapping("/gpu/{id}")
    public GPU getGPUById(@PathVariable(value = "id") Long gpuId, HttpServletRequest request) {
        Log.createLog(0, "getGPUById query received by " + request.getRemoteAddr());
        return gpuService.getGPUById(gpuId);
    }

    @PostMapping("/gpu")
    public GPU createGPU(@Valid @RequestBody GPU gpu, HttpServletRequest request) {
        Log.createLog(0, "createGPU query received by " + request.getRemoteAddr());
        return gpuService.createGPU(gpu);
    }

    @DeleteMapping("/gpu/{id}")
    public ResponseEntity<?> deleteGPU(@PathVariable(value = "id") Long gpuId, HttpServletRequest request) {
        Log.createLog(0, "deleteGPU query received by " + request.getRemoteAddr());
        gpuService.deleteGPU(gpuId);
        return ResponseEntity.ok().build();
    }

}
