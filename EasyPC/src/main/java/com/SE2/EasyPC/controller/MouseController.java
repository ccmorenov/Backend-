package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Mouse;
import com.SE2.EasyPC.service.MouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//permit cross origin requests
@CrossOrigin
@RestController
@RequestMapping("/api")
public class MouseController {
    
    //declares corresponding service
    @Autowired
    MouseService mouseService;

    //get http request for all mice
    @GetMapping("/mice")
    public List<Mouse> getAllMice(HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return mouseService.getAllMice();
    }

    //get http request for mouse by specific ID
    @GetMapping("/mouse/{id}")
    public Mouse getMouseById(@PathVariable(value = "id") Long mouseId, HttpServletRequest request) {
        //append to log

        //return the corresponding service logical function
        return mouseService.getMouseById(mouseId);
    }

    //Post http request for mouse
    @PostMapping("/mouse")
    //request body with object to post
    public Mouse createMouse(@Valid @RequestBody Mouse mouse, HttpServletRequest request) {
        //append to log

        //return the corresponding service logical function
        return mouseService.createMouse(mouse);
    }

    //Delete http request for mouse by ID
    @DeleteMapping("/mouse/{id}")
    public ResponseEntity<?> deleteMouse(@PathVariable(value = "id") Long mouseId, HttpServletRequest request) {
        //append to log

        //call the corresponding service logical function
        mouseService.deleteMouse(mouseId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
