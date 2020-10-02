package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Keyboard;
import com.SE2.EasyPC.service.KeyboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class KeyboardController {
    
    @Autowired
    KeyboardService keyboardService;

    @GetMapping("/keyboards")
    public List<Keyboard> getAllKeyboards() {
        return keyboardService.getAllKeyboards();
    }

    @GetMapping("/keyboard/{id}")
    public Keyboard getKeyboardById(@PathVariable(value = "id") Long keyboardId) {
        return keyboardService.getKeyboardById(keyboardId);
    }

    @PostMapping("/keyboard")
    public Keyboard createKeyboard(@Valid @RequestBody Keyboard keyboard) {
        return keyboardService.createKeyboard(keyboard);
    }

    @DeleteMapping("/keyboard/{id}")
    public ResponseEntity<?> deleteKeyboard(@PathVariable(value = "id") Long keyboardId) {
        keyboardService.deleteKeyboard(keyboardId);
        return ResponseEntity.ok().build();
    }

}
