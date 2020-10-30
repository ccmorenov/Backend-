package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.GPU;
import com.SE2.EasyPC.dataAccess.repository.GPURepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for GPU, recives calls from GPUController and calls GPURepository
@Service
public class GPUService {
    
    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    GPURepository gpuRepository; 

    public List<GPU> getAllGPUs() { // returns a list with all GPUs in the database
        try{
            return gpuRepository.findAll();
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public GPU getGPUById( Long id ) { // returns the GPU with the requested ID or an exception if it does not exist
        try{
            return gpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GPU", "id", id));
        }catch(Exception e){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
        
    }

    public GPU createGPU(GPU gpu) { // creates a new GPU in the database
        try{
            return gpuRepository.save(gpu);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public void deleteGPU( Long id ) { // deletes the GPU with the requested ID or an exception if it does not exist
        try{
            GPU gpu = gpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GPU", "id", id));
            gpuRepository.delete(gpu);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

}