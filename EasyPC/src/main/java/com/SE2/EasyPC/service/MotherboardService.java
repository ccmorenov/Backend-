package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.dataAccess.repository.MotherboardRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotherboardService {
    
    @Autowired
    MotherboardRepository motherboardRepository; 
    public List<Motherboard> getAllMotherboards() {
        try{
            return motherboardRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllMotherboards failed: " + e.getMessage() );
            throw e;
        }
    }

    public Motherboard getMotherboardById( Long id ) {
        try{
            return motherboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getMotherboardById failed: " + e.getMessage() );
            throw e;
        }
    }

    public Motherboard createMotherboard(Motherboard motherboard) {
        try{
            return motherboardRepository.save(motherboard);
        }catch( Exception e ){
            Log.createLog(3, "Service createMotherboard failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteMotherboard( Long id ) {
        try{
            Motherboard motherboard = motherboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", id));
            motherboardRepository.delete(motherboard);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteMotherboard failed: " + e.getMessage() );
            throw e;
        }
    }

}
