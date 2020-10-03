package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.service.MotherboardService;
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
public class MotherboardController {
    
    @Autowired
    MotherboardService motherboardService;

    @GetMapping("/motherboards")
    public List<Motherboard> getAllMotherboards(HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        return motherboardService.getAllMotherboards();
    }

    @GetMapping("/motherboard/{id}")
    public Motherboard getMotherboardById(@PathVariable(value = "id") Long motherboardId,HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        return motherboardService.getMotherboardById(motherboardId);
    }

    @PostMapping("/motherboard")
    public Motherboard createMotherboard(@Valid @RequestBody Motherboard motherboard,HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        return motherboardService.createMotherboard(motherboard);
    }

    @DeleteMapping("/motherboard/{id}")
    public ResponseEntity<?> deleteMotherboard(@PathVariable(value = "id") Long motherboardId,HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        motherboardService.deleteMotherboard(motherboardId);
        return ResponseEntity.ok().build();
    }
}
