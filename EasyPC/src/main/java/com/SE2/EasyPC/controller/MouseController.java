package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Mouse;
import com.SE2.EasyPC.service.MouseService;
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
public class MouseController {
    
    @Autowired
    MouseService mouseService;

    @GetMapping("/mice")
    public List<Mouse> getAllMice(HttpServletRequest request ) {
        Log.createLog(0, "getAllMice query received by " + request.getRemoteAddr());
        return mouseService.getAllMice();
    }

    @GetMapping("/mouse/{id}")
    public Mouse getMouseById(@PathVariable(value = "id") Long mouseId, HttpServletRequest request) {
        Log.createLog(0, "getMouseById query received by " + request.getRemoteAddr() );
        return mouseService.getMouseById(mouseId);
    }

    @PostMapping("/mouse")
    public Mouse createMouse(@Valid @RequestBody Mouse mouse, HttpServletRequest request) {
        Log.createLog(0, "createMouse query received by " + request.getRemoteAddr() );
        return mouseService.createMouse(mouse);
    }

    @DeleteMapping("/mouse/{id}")
    public ResponseEntity<?> deleteMouse(@PathVariable(value = "id") Long mouseId, HttpServletRequest request) {
        Log.createLog(0, "deleteMouse query received by " + request.getRemoteAddr() );
        mouseService.deleteMouse(mouseId);
        return ResponseEntity.ok().build();
    }
}
