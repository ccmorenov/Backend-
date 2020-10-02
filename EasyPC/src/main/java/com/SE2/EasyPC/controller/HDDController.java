package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.HDD;
import com.SE2.EasyPC.service.HDDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class HDDController {
    
    @Autowired
    HDDService hddService;

    @GetMapping("/hdds")
    public List<HDD> getAllHDDs() {
        return hddService.getAllHDDs();
    }

    @GetMapping("/hdd/{id}")
    public HDD getHDDById(@PathVariable(value = "id") Long hddId) {
        return hddService.getHDDById(hddId);
    }

    @PostMapping("/hdd")
    public HDD createHDD(@Valid @RequestBody HDD hdd) {
        return hddService.createHDD(hdd);
    }

    @DeleteMapping("/hdd/{id}")
    public ResponseEntity<?> deleteHDD(@PathVariable(value = "id") Long hddId) {
        hddService.deleteHDD(hddId);
        return ResponseEntity.ok().build();
    }

}
