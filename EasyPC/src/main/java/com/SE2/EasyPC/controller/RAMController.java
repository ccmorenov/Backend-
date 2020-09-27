package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.RAM;
import com.SE2.EasyPC.service.RAMService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RAMController {
    
    @Autowired
    RAMService ramService;

    @GetMapping("/rams")
    public List<RAM> getAllRAMs() {
        return ramService.getAllRAMs();
    }

    @GetMapping("/ram/{id}")
    public RAM getRAMById(@PathVariable(value = "id") Long ramId) {
        return ramService.getRAMById(ramId);
    }

    @PostMapping("/ram")
    public RAM createRAM(@Valid @RequestBody RAM ram) {
        return ramService.createRAM(ram);
    }

    @DeleteMapping("/ram/{id}")
    public ResponseEntity<?> deleteRAM(@PathVariable(value = "id") Long ramId) {
        ramService.deleteRAM(ramId);
        return ResponseEntity.ok().build();
    }
}
