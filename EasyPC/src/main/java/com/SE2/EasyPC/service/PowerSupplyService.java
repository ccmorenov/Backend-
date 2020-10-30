package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.PowerSupply;
import com.SE2.EasyPC.dataAccess.repository.PowerSupplyRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Business logic layer for PowerSupply, recives calls from PowerSupplyController and calls PowerSupplyRepository
@Service
public class PowerSupplyService {
    
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    PowerSupplyRepository powerSupplyRepository; 

    public List<PowerSupply> getAllPowerSupplies() { // returns a list with all Power Supplies in the database
        try{
            return powerSupplyRepository.findAll();
        }catch( Exception e ){
            logger.warn( "Exception at " + new Object(){}.getClass().getEnclosingMethod().getName() + " method of " + this.getClass().getSimpleName() + ": " + e );
            throw e;
        }
        
    }

    public PowerSupply getPowerSupplyById( Long id ) { // returns the Power Supply with the requested ID or an exception if it does not exist
        try{
            return powerSupplyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PowerSupply", "id", id));
        }catch( Exception e ){

            throw e;
        }
        
    }

    public PowerSupply createPowerSupply(PowerSupply powerSupply) { // creates a new Power Supply in the database
        try{
            return powerSupplyRepository.save(powerSupply);
        }catch( Exception e ){

            throw e;
        }
        
    }

    public void deletePowerSupply( Long id ) { // deletes the Power Supply with the requested ID or an exception if it does not exist
        try{
            PowerSupply powerSupply = powerSupplyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PowerSupply", "id", id));
            powerSupplyRepository.delete(powerSupply);
        }catch( Exception e ){

            throw e;
        }
        
    }
}
