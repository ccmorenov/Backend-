package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Cooling;
import com.SE2.EasyPC.dataAccess.repository.CoolingRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for Cooling, recives calls from CoolingController and calls CoolingRepository
@Service
public class CoolingService {
    @Autowired
    CoolingRepository coolingRepository; 

    public List<Cooling> getAllCoolings() { // returns a list with all Coolings in the database
        try{
            return coolingRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllCoolings failed: " + e.getMessage() );
            throw e;
        }
    }

    public Cooling getCoolingById( Long id ) { // returns the Cooling with the requested ID or an exception if it does not exist
        try{
            return coolingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cooling", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getCoolingById failed: " + e.getMessage() );
            throw e;
        }
    }

    public Cooling createCooling(Cooling cooling) { // creates a new Cooling in the database
        try{
            return coolingRepository.save(cooling);
        }catch( Exception e ){
            Log.createLog(3, "Service createCooling failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteCooling( Long id ) { // deletes the Cooling with the requested ID or an exception if it does not exist
        try{
            Cooling cooling = coolingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cooling", "id", id));
            coolingRepository.delete(cooling);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteCooling failed: " + e.getMessage() );
            throw e;
        }
    }
}
