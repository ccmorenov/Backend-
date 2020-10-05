package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.logging.Log;
import com.SE2.EasyPC.service.BuildService;

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
public class BuildController {

    //declares corresponding service
    @Autowired
    BuildService buildService;

    //get http request for all builds
    @GetMapping("/builds")
    public List<Build> getAllBuilds( HttpServletRequest request ) {
        //append to log
        Log.createLog(0, "getAllBuilds query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return buildService.getAllBuilds();
    }

    //get http request for build by specific ID
    @GetMapping("/build/{id}")
    public Build getBuildById(@PathVariable(value = "id") Long buildId,  HttpServletRequest request ) {
        //append to log
        Log.createLog(0, "getBuildById query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return buildService.getBuildById(buildId);
    }

    //Post http request for build
    @PostMapping("/build")
    //request body with object to post
    public Build createBuild(@Valid @RequestBody Build build,  HttpServletRequest request ) {
        //append to log
        Log.createLog(0, "createBuild query received by " + request.getRemoteAddr());
        //return the corresponding service logical function
        return buildService.createBuild(build);
    }

    //Delete http request for build by ID
    @DeleteMapping("/build/{id}")
    public ResponseEntity<?> deleteBuild(@PathVariable(value = "id") Long buildId,  HttpServletRequest request ) {
        //append to log
        Log.createLog(0, "deleteBuild query received by " + request.getRemoteAddr());
        //call the corresponding service logical function
        buildService.deleteBuild(buildId);
        //Check deletion
        return ResponseEntity.ok().build();
    }
}
