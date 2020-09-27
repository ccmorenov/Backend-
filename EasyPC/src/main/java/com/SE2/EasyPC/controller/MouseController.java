package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Mouse;
import com.SE2.EasyPC.service.MouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MouseController {
    
    @Autowired
    MouseService mouseService;

    @GetMapping("/mice")
    public List<Mouse> getAllMice() {
        return mouseService.getAllMice();
    }

    @GetMapping("/mouse/{id}")
    public Mouse getMouseById(@PathVariable(value = "id") Long mouseId) {
        return mouseService.getMouseById(mouseId);
    }

    @PostMapping("/mouse")
    public Mouse createMouse(@Valid @RequestBody Mouse mouse) {
        return mouseService.createMouse(mouse);
    }

    @DeleteMapping("/mouse/{id}")
    public ResponseEntity<?> deleteMouse(@PathVariable(value = "id") Long mouseId) {
        mouseService.deleteMouse(mouseId);
        return ResponseEntity.ok().build();
    }
}
