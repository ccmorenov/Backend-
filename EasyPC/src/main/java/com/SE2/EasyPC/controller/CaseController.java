package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.service.CaseService;
import com.SE2.EasyPC.dataAccess.model.Case;

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
public class CaseController {

    //declares corresponding service
    @Autowired
    CaseService caseService;

    //get http request for all cases
    @GetMapping("/cases")
    public List<Case> getAllCases( HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return caseService.getAllCases();
    }

    //get http request for case by specific ID
    @GetMapping("/case/{id}")
    public Case getCaseById(@PathVariable(value = "id") Long CaseId , HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return caseService.getCaseById(CaseId);
    }

    //Post http request for case
    @PostMapping("/case")
    //request body with object to post
    public Case createCase(@Valid @RequestBody Case caseObj , HttpServletRequest request ) {
        //append to log

        //return the corresponding service logical function
        return caseService.createCase(caseObj);
    }

    //Delete http request for case by ID
    @DeleteMapping("/case/{id}")
    public ResponseEntity<?> deleteCase(@PathVariable(value = "id") Long CaseId , HttpServletRequest request) {
        //append to log

        //call the corresponding service logical function
        caseService.deleteCase(CaseId);
        //Check deletion
        return ResponseEntity.ok().build();
    }


}
