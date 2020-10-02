package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.GPU;
import com.SE2.EasyPC.service.GPUService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GPUController {
    
    @Autowired
    GPUService gpuService;

    @GetMapping("/gpus")
    public List<GPU> getAllGPUs() {
        return gpuService.getAllGPUs();
    }

    @GetMapping("/gpu/{id}")
    public GPU getGPUById(@PathVariable(value = "id") Long gpuId) {
        return gpuService.getGPUById(gpuId);
    }

    @PostMapping("/gpu")
    public GPU createGPU(@Valid @RequestBody GPU gpu) {
        return gpuService.createGPU(gpu);
    }

    @DeleteMapping("/gpu/{id}")
    public ResponseEntity<?> deleteGPU(@PathVariable(value = "id") Long gpuId) {
        gpuService.deleteGPU(gpuId);
        return ResponseEntity.ok().build();
    }

}
