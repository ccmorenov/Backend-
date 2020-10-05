package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Keyboard;
import com.SE2.EasyPC.service.KeyboardService;

import com.SE2.EasyPC.logging.Log;

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
public class KeyboardController {
    
    //declares corresponding service
    @Autowired
    KeyboardService keyboardService;

    //get http request for all keyboards
    @GetMapping("/keyboards")
    public List<Keyboard> getAllKeyboards( HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getAllKeyboards query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return keyboardService.getAllKeyboards();
    }

    //get http request for keyboard by specific ID
    @GetMapping("/keyboard/{id}")
    public Keyboard getKeyboardById(@PathVariable(value = "id") Long keyboardId, HttpServletRequest request) {
        //append to log
        Log.createLog(0, "getKeyboardById query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return keyboardService.getKeyboardById(keyboardId);
    }

    //Post http request for keyboard
    @PostMapping("/keyboard")
    //request body with object to post
    public Keyboard createKeyboard(@Valid @RequestBody Keyboard keyboard, HttpServletRequest request) {
        //append to log
        Log.createLog(0, "createKeyboard query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return keyboardService.createKeyboard(keyboard);
    }

    //Delete http request for keyboard by hdd
    @DeleteMapping("/keyboard/{id}")
    public ResponseEntity<?> deleteKeyboard(@PathVariable(value = "id") Long keyboardId, HttpServletRequest request) {
        //append to log
        Log.createLog(0, "deleteKeyboard query received by " + request.getRemoteAddr());
        //call the corresponding service logical function
        keyboardService.deleteKeyboard(keyboardId);
        //Check deletion
        return ResponseEntity.ok().build();
    }

}
