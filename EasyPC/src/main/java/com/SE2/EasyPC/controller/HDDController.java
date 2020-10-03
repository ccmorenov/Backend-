package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.HDD;
import com.SE2.EasyPC.service.HDDService;
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
public class HDDController {
    
    @Autowired
    HDDService hddService;

    @GetMapping("/hdds")
    public List<HDD> getAllHDDs(HttpServletRequest request) {
        Log.createLog(0, "getAllHDDs query received by " + request.getRemoteAddr());
        return hddService.getAllHDDs();
    }

    @GetMapping("/hdd/{id}")
    public HDD getHDDById(@PathVariable(value = "id") Long hddId, HttpServletRequest request) {
        Log.createLog(0, "getHDDById query received by " + request.getRemoteAddr());
        return hddService.getHDDById(hddId);
    }

    @PostMapping("/hdd")
    public HDD createHDD(@Valid @RequestBody HDD hdd, HttpServletRequest request) {
        Log.createLog(0, "createHDD query received by " + request.getRemoteAddr());
        return hddService.createHDD(hdd);
    }

    @DeleteMapping("/hdd/{id}")
    public ResponseEntity<?> deleteHDD(@PathVariable(value = "id") Long hddId, HttpServletRequest request) {
        Log.createLog(0, "deleteHDD query received by " + request.getRemoteAddr());
        hddService.deleteHDD(hddId);
        return ResponseEntity.ok().build();
    }

}
