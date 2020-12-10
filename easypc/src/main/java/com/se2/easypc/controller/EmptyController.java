package com.se2.easypc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmptyController {
    @GetMapping(value = "/")
    public ResponseEntity index() {
        return ResponseEntity.ok("empty");
    }
}
