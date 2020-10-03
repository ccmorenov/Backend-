package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Monitor;
import com.SE2.EasyPC.service.MonitorService;
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
public class MonitorController {
    
    @Autowired
    MonitorService monitorService;

    @GetMapping("/monitors")
    public List<Monitor> getAllMonitors(HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        return monitorService.getAllMonitors();
    }

    @GetMapping("/monitor/{id}")
    public Monitor getMonitorById(@PathVariable(value = "id") Long monitorId,HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        return monitorService.getMonitorById(monitorId);
    }

    @PostMapping("/monitor")
    public Monitor createMonitor(@Valid @RequestBody Monitor monitor,HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        return monitorService.createMonitor(monitor);
    }

    @DeleteMapping("/monitor/{id}")
    public ResponseEntity<?> deleteMonitor(@PathVariable(value = "id") Long monitorId,HttpServletRequest request) {
        Log.createLog(0, "getAllAdmins query received by " + request.getRemoteAddr());
        monitorService.deleteMonitor(monitorId);
        return ResponseEntity.ok().build();
    }

}
