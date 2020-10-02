package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.service.CaseService;
import com.SE2.EasyPC.dataAccess.model.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CaseController {
    @Autowired
    CaseService caseService;

    @GetMapping("/cases")
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/case/{id}")
    public Case getCaseById(@PathVariable(value = "id") Long CaseId) {
        return caseService.getCaseById(CaseId);
    }

    @PostMapping("/case")
    public Case createCase(@Valid @RequestBody Case caseObj) {
        return caseService.createCase(caseObj);
    }

    @DeleteMapping("/case/{id}")
    public ResponseEntity<?> deleteCase(@PathVariable(value = "id") Long CaseId) {
        caseService.deleteCase(CaseId);
        return ResponseEntity.ok().build();
    }


}
