package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.SSD;
import com.SE2.EasyPC.service.SSDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SSDController {
    
    @Autowired
    SSDService ssdService;

    @GetMapping("/ssds")
    public List<SSD> getAllSSDs() {
        return ssdService.getAllSSDs();
    }

    @GetMapping("/ssd/{id}")
    public SSD getSSDById(@PathVariable(value = "id") Long ssdId) {
        return ssdService.getSSDById(ssdId);
    }

    @PostMapping("/ssd")
    public SSD createSSD(@Valid @RequestBody SSD ssd) {
        return ssdService.createSSD(ssd);
    }

    @DeleteMapping("/ssd/{id}")
    public ResponseEntity<?> deleteSSD(@PathVariable(value = "id") Long ssdId) {
        ssdService.deleteSSD(ssdId);
        return ResponseEntity.ok().build();
    }

}
