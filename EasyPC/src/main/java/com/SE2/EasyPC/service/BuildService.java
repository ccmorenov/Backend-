package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.dataAccess.repository.BuildRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildService {
    @Autowired
    BuildRepository buildRepository; 

    public List<Build> getAllBuilds() {
        return buildRepository.findAll();
    }

    public Build getBuildById( Long id ) {
        return buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
    }

    public Build createBuild(Build build) {
        return buildRepository.save(build);
    }

    public void deleteBuild( Long id ) {
        Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
        buildRepository.delete(build);
    }
    
}
