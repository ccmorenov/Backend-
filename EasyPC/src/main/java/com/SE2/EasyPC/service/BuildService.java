package com.SE2.EasyPC.service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Build;
import com.SE2.EasyPC.dataAccess.repository.BuildRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for Build, recives calls from BuildService and calls BuildRepository
@Service
public class BuildService {
    @Autowired
    BuildRepository buildRepository; 

    public List<Build> getAllBuilds() { // returns a list with all Builds in the database
        try{
            return buildRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllBuilds failed: " + e.getMessage() );
            throw e;
        }
    }

    public Build getBuildById( Long id ) { // returns the Build with the requested ID or an exception if it does not exist
        try{
            return buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getBuildById failed: " + e.getMessage() );
            throw e;
        }
    }

    public Build createBuild(Build build) { // creates a new Build in the database
        try{
            if( build.getDate() == null ) build.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ) );
            return buildRepository.save(build);
        }catch( Exception e ){
            Log.createLog(3, "Service createBuild failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteBuild( Long id ) { // deletes the Build with the requested ID or an exception if it does not exist
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
        buildRepository.delete(build);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteBuild failed: " + e.getMessage() );
            throw e;
        }

    }
    
}
