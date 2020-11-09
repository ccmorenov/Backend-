package com.se2.easypc.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.se2.easypc.data_access.model.Build;
import com.se2.easypc.data_access.model.User;
import com.se2.easypc.data_access.repository.BuildRepository;
import com.se2.easypc.exception.ResourceNotFoundException;
import com.se2.easypc.pojo.BuildPOJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Build, recives calls from BuildService and calls BuildRepository
@Service
public class BuildService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    BuildRepository buildRepository;

    @Autowired
    UserService userService;

    public List<BuildPOJO> getAllBuilds() { // returns a list with all Builds in the database
        try{
            List<BuildPOJO> builds = new ArrayList<>();
            for( Build b : buildRepository.findAll() ){
                builds.add( new BuildPOJO( b ) );
            }
            return builds;
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public BuildPOJO getBuildById( Long id ) { // returns the Build with the requested ID or an exception if it does not exist
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
            return new BuildPOJO(build);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public BuildPOJO createBuild(BuildPOJO buildPOJO , User user) { // creates a new Build in the database
        try{
            Build build = buildPOJO.toBuild();
            if (user == null){
               user = userService.getUserById((long)1);
            }
            build.setUser(user);
            if( build.getDate() == null ) build.setDate( new java.sql.Date( Calendar.getInstance().getTime().getTime() ) );
            build = buildRepository.save(build);
            return new BuildPOJO(build);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public void deleteBuild( Long id ) { // deletes the Build with the requested ID or an exception if it does not exist
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
            buildRepository.delete(build);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public Integer getBuildPriceById( Long id ) { // returns the price of an spcefic build
        try{
            Build build = buildRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Build", "id", id));
            return build.getPrice();
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }
    
}
