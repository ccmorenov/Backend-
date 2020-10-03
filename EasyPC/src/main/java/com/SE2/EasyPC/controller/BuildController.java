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

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BuildController {
    @Autowired
    BuildService buildService;

    @GetMapping("/builds")
    public List<Build> getAllBuilds( HttpServletRequest request ) {
        Log.createLog(0, "getAllBuilds query received by " + request.getRemoteAddr());
        return buildService.getAllBuilds();
    }

    @GetMapping("/build/{id}")
    public Build getBuildById(@PathVariable(value = "id") Long buildId,  HttpServletRequest request ) {
        Log.createLog(0, "getBuildById query received by " + request.getRemoteAddr());
        return buildService.getBuildById(buildId);
    }

    @PostMapping("/build")
    public Build createBuild(@Valid @RequestBody Build build,  HttpServletRequest request ) {
        Log.createLog(0, "createBuild query received by " + request.getRemoteAddr());
        return buildService.createBuild(build);
    }

    @DeleteMapping("/build/{id}")
    public ResponseEntity<?> deleteBuild(@PathVariable(value = "id") Long buildId,  HttpServletRequest request ) {
        Log.createLog(0, "deleteBuild query received by " + request.getRemoteAddr());
        buildService.deleteBuild(buildId);
        return ResponseEntity.ok().build();
    }
}
