package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.RAM;
import com.SE2.EasyPC.service.RAMService;
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
public class RAMController {
    
    @Autowired
    RAMService ramService;

    @GetMapping("/rams")
    public List<RAM> getAllRAMs(HttpServletRequest request ) {
        Log.createLog(0, "getAllRAMs query received by " + request.getRemoteAddr());
        return ramService.getAllRAMs();
    }

    @GetMapping("/ram/{id}")
    public RAM getRAMById(@PathVariable(value = "id") Long ramId, HttpServletRequest request) {
        Log.createLog(0, "getRAMById query received by " + request.getRemoteAddr() );
        return ramService.getRAMById(ramId);
    }

    @PostMapping("/ram")
    public RAM createRAM(@Valid @RequestBody RAM ram, HttpServletRequest request) {
        Log.createLog(0, "createRAM query received by " + request.getRemoteAddr() );
        return ramService.createRAM(ram);
    }

    @DeleteMapping("/ram/{id}")
    public ResponseEntity<?> deleteRAM(@PathVariable(value = "id") Long ramId, HttpServletRequest request) {
        Log.createLog(0, "deleteRAM query received by " + request.getRemoteAddr() );
        ramService.deleteRAM(ramId);
        return ResponseEntity.ok().build();
    }
}
