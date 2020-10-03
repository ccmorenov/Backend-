package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.GPU;
import com.SE2.EasyPC.dataAccess.repository.GPURepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPUService {
    
    @Autowired
    GPURepository gpuRepository; 

    public List<GPU> getAllGPUs() {
        try{
            return gpuRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllGPUs failed: " + e.getMessage() );
            throw e;
        }
    }

    public GPU getGPUById( Long id ) {
        try{
            return gpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GPU", "id", id));
        }catch(Exception e){
            Log.createLog(3, "Service getGPUById failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public GPU createGPU(GPU gpu) {
        try{
            return gpuRepository.save(gpu);
        }catch( Exception e ){
            Log.createLog(3, "Service createGPU failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteGPU( Long id ) {
        try{
            GPU gpu = gpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GPU", "id", id));
            gpuRepository.delete(gpu);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteGPU failed: " + e.getMessage() );
            throw e;
        }
    }

}