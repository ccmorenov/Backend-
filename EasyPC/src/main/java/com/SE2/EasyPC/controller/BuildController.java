package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.service.BuildService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BuildController {
    @Autowired
    BuildService buildService;

    @GetMapping("/builds")
    public List<Build> getAllBuilds() {
        return buildService.getAllBuilds();
    }

    @GetMapping("/build/{id}")
    public Build getBuildById(@PathVariable(value = "id") Long buildId) {
        return buildService.getBuildById(buildId);
    }

    @PostMapping("/build")
    public Build createBuild(@Valid @RequestBody Build build) {
        return buildService.createBuild(build);
    }

    @DeleteMapping("/build/{id}")
    public ResponseEntity<?> deleteBuild(@PathVariable(value = "id") Long buildId) {
        buildService.deleteBuild(buildId);
        return ResponseEntity.ok().build();
    }
}
