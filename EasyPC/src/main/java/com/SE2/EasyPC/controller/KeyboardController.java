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

@CrossOrigin
@RestController
@RequestMapping("/api")
public class KeyboardController {
    
    @Autowired
    KeyboardService keyboardService;

    @GetMapping("/keyboards")
    public List<Keyboard> getAllKeyboards( HttpServletRequest request) {
        Log.createLog(0, "getAllKeyboards query received by " + request.getRemoteAddr());
        return keyboardService.getAllKeyboards();
    }

    @GetMapping("/keyboard/{id}")
    public Keyboard getKeyboardById(@PathVariable(value = "id") Long keyboardId, HttpServletRequest request) {
        Log.createLog(0, "getKeyboardById query received by " + request.getRemoteAddr());
        return keyboardService.getKeyboardById(keyboardId);
    }

    @PostMapping("/keyboard")
    public Keyboard createKeyboard(@Valid @RequestBody Keyboard keyboard, HttpServletRequest request) {
        Log.createLog(0, "createKeyboard query received by " + request.getRemoteAddr());
        return keyboardService.createKeyboard(keyboard);
    }

    @DeleteMapping("/keyboard/{id}")
    public ResponseEntity<?> deleteKeyboard(@PathVariable(value = "id") Long keyboardId, HttpServletRequest request) {
        keyboardService.deleteKeyboard(keyboardId);
        Log.createLog(0, "deleteKeyboard query received by " + request.getRemoteAddr());
        return ResponseEntity.ok().build();
    }

}
