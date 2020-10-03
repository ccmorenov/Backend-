package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.SSD;
import com.SE2.EasyPC.service.SSDService;
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
public class SSDController {
    
    @Autowired
    SSDService ssdService;

    @GetMapping("/ssds")
    public List<SSD> getAllSSDs(HttpServletRequest request ) {
        Log.createLog(0, "getAllSSDs query received by " + request.getRemoteAddr());
        return ssdService.getAllSSDs();
    }

    @GetMapping("/ssd/{id}")
    public SSD getSSDById(@PathVariable(value = "id") Long ssdId, HttpServletRequest request) {
        Log.createLog(0, "getSSDById query received by " + request.getRemoteAddr() );
        return ssdService.getSSDById(ssdId);
    }

    @PostMapping("/ssd")
    public SSD createSSD(@Valid @RequestBody SSD ssd, HttpServletRequest request) {
        Log.createLog(0, "createSSD query received by " + request.getRemoteAddr() );
        return ssdService.createSSD(ssd);
    }

    @DeleteMapping("/ssd/{id}")
    public ResponseEntity<?> deleteSSD(@PathVariable(value = "id") Long ssdId, HttpServletRequest request) {
        Log.createLog(0, "deleteSSD query received by " + request.getRemoteAddr() );
        ssdService.deleteSSD(ssdId);
        return ResponseEntity.ok().build();
    }

}
