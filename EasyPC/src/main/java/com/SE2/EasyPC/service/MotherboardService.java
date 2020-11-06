package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.CPU;
import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.dataAccess.repository.MotherboardRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for Motherboard, recives calls from MotherboardController and calls MotherboardRepository
@Service
public class MotherboardService {

    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    MotherboardRepository motherboardRepository; 
    public List<Motherboard> getAllMotherboards() { // returns a list with all Motherboards in the database
        try{
            return motherboardRepository.findAll();
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public Motherboard getMotherboardById( Long i ) { // returns the Motherboard with the requested ID or an exception if it does not exist
        try{
            return motherboardRepository.findById(i).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", i));
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public Motherboard createMotherboard(Motherboard motherboard) { // creates a new Motherboard in the database
        try{
            return motherboardRepository.save(motherboard);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public void deleteMotherboard( Long id ) { // deletes the Motherboard with the requested ID or an exception if it does not exist
        try{
            Motherboard motherboard = motherboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", id));
            motherboardRepository.delete(motherboard);
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
    }

    public List<CPU> getCompatibleCPUsById( Long motheboardId ) { // returns all compatible CPUs given the id of a motherboard
        Motherboard motherboard = getMotherboardById(motheboardId);
        if( motherboard == null ) return null;
        return motherboard.getCompatibleCPUs();
    }

}
