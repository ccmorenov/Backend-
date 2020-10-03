package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.RAM;
import com.SE2.EasyPC.dataAccess.repository.RAMRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RAMService {
    
    @Autowired
    RAMRepository ramRepository; 

    public List<RAM> getAllRAMs() {
        try{
            return ramRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllRAMs failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public RAM getRAMById( Long id ) {
        try{
            return ramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RAM", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getRAMById failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public RAM createRAM(RAM ram) {
        try{
            return ramRepository.save(ram);
        }catch( Exception e ){
            Log.createLog(3, "Service createRAM failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public void deleteRAM( Long id ) {
        try{
            RAM ram = ramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RAM", "id", id));
            ramRepository.delete(ram);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteRAM failed: " + e.getMessage() );
            throw e;
        }
        RAM ram = ramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RAM", "id", id));
        ramRepository.delete(ram);
    }
}
