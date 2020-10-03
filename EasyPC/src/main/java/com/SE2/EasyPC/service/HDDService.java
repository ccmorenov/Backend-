package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.HDD;
import com.SE2.EasyPC.dataAccess.repository.HDDRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for HDD, recives calls from HDDController and calls HDDRepository
@Service
public class HDDService {
    
    @Autowired
    HDDRepository hddRepository; 

    public List<HDD> getAllHDDs() { // returns a list with all HDDs in the database
        try{
            return hddRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllHDDs failed: " + e.getMessage() );
            throw e;
        }
    }

    public HDD getHDDById( Long id ) { // returns the HDD with the requested ID or an exception if it does not exist
        try{
            return hddRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("HDD", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getHDDById failed: " + e.getMessage() );
            throw e;
        }
    }

    public HDD createHDD(HDD hdd) { // creates a new HDD in the database
        try{
            return hddRepository.save(hdd);
        }catch( Exception e ){
            Log.createLog(3, "Service createHDD failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteHDD( Long id ) { // deletes the HDD with the requested ID or an exception if it does not exist
        try{
            HDD hdd = hddRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("HDD", "id", id));
            hddRepository.delete(hdd);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteHDD failed: " + e.getMessage() );
            throw e;
        }
    }

}
