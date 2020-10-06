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

//permit cross origin requests|
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MonitorController {
    
    //declares corresponding service
    @Autowired
    MonitorService monitorService;

    //get http request for all monitors
    @GetMapping("/monitors")
    public List<Monitor> getAllMonitors(HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getAllmonitors query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return monitorService.getAllMonitors();
    }

    //get http request for monitor by specific ID
    @GetMapping("/monitor/{id}")
    public Monitor getMonitorById(@PathVariable(value = "id") Long monitorId,HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getMonitorById query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return monitorService.getMonitorById(monitorId);
    }

    //Post http request for monitor
    @PostMapping("/monitor")
    //request body with object to post
    public Monitor createMonitor(@Valid @RequestBody Monitor monitor,HttpServletRequest request) {
        //append to log
        Log.createLog(0, "createMonitor query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return monitorService.createMonitor(monitor);
    }

    //Delete http request for monitor by ID
    @DeleteMapping("/monitor/{id}")
    public ResponseEntity<?> deleteMonitor(@PathVariable(value = "id") Long monitorId,HttpServletRequest request) {
        //append to log
        Log.createLog(0, "deleteMonitor query received by " + request.getRemoteAddr());
        //call the corresponding service logical function
        monitorService.deleteMonitor(monitorId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
