package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Monitor;
import com.SE2.EasyPC.service.MonitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MonitorController {
    
    @Autowired
    MonitorService monitorService;

    @GetMapping("/monitors")
    public List<Monitor> getAllMonitors() {
        return monitorService.getAllMonitors();
    }

    @GetMapping("/monitor/{id}")
    public Monitor getMonitorById(@PathVariable(value = "id") Long monitorId) {
        return monitorService.getMonitorById(monitorId);
    }

    @PostMapping("/monitor")
    public Monitor createMonitor(@Valid @RequestBody Monitor monitor) {
        return monitorService.createMonitor(monitor);
    }

    @DeleteMapping("/monitor/{id}")
    public ResponseEntity<?> deleteMonitor(@PathVariable(value = "id") Long monitorId) {
        monitorService.deleteMonitor(monitorId);
        return ResponseEntity.ok().build();
    }

}
