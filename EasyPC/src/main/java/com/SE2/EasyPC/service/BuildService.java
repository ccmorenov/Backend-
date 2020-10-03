package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.dataAccess.repository.BuildRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildService {
    @Autowired
    BuildRepository buildRepository; 

    public List<Build> getAllBuilds() {
        try{
            return buildRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllBuilds failed: " + e.getMessage() );
            throw e;
        }
    }

    public Build getBuildById( Long id ) {
        try{
            return buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getBuildById failed: " + e.getMessage() );
            throw e;
        }
    }

    public Build createBuild(Build build) {
        try{
            return buildRepository.save(build);
        }catch( Exception e ){
            Log.createLog(3, "Service createBuild failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteBuild( Long id ) {
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
        buildRepository.delete(build);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteBuild failed: " + e.getMessage() );
            throw e;
        }

    }
    
}
