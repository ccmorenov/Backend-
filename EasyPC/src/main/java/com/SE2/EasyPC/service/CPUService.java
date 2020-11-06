package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.CPU;
import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.dataAccess.repository.CPURepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for CPU, recives calls from CPUController and calls CPURepository
@Service
public class CPUService {

    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    CPURepository cpuRepository; 

    public List<CPU> getAllCPUs() { // returns a list with all CPUs in the database
        try{
            return cpuRepository.findAll();
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public CPU getCPUById( Long id ) { // returns the CPU with the requested ID or an exception if it does not exist
        try{
            return cpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CPU", "id", id));
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public CPU createCPU(CPU cpu) { // creates a new CPU in the database
        try{
            return cpuRepository.save(cpu);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public void deleteCPU( Long id ) { // deletes the CPU with the requested ID or an exception if it does not exist
        try{
            CPU cpu = cpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CPU", "id", id));
            cpuRepository.delete(cpu);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public List<Motherboard> getCompatibleMotherboardsById( Long cpuId ) { // returns compatible Motherboards with the CPU of the given id
        CPU cpu = getCPUById(cpuId);
        if( cpu == null ) return null;
        return cpu.getCompatibleMotherboards();
    }

}