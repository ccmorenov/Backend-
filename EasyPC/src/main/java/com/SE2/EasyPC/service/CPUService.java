package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.CPU;
import com.SE2.EasyPC.dataAccess.repository.CPURepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPUService {
    
    @Autowired
    CPURepository cpuRepository; 

    public List<CPU> getAllCPUs() {
        try{
            return cpuRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllCPUs failed: " + e.getMessage() );
            throw e;
        }
    }

    public CPU getCPUById( Long id ) {
        try{
            return cpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CPU", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getCPUById failed: " + e.getMessage() );
            throw e;
        }
    }

    public CPU createCPU(CPU cpu) {
        try{
            return cpuRepository.save(cpu);
        }catch( Exception e ){
            Log.createLog(3, "Service createCPU failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteCPU( Long id ) {
        try{
            CPU cpu = cpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CPU", "id", id));
            cpuRepository.delete(cpu);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteCPU failed: " + e.getMessage() );
            throw e;
        }
    }

}