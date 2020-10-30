package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Monitor;
import com.SE2.EasyPC.dataAccess.repository.MonitorRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for Monitor, recives calls from MonitorController and calls MonitorRepository
@Service
public class MonitorService {
    
    @Autowired
    MonitorRepository monitorRepository; 

    public List<Monitor> getAllMonitors() { // returns a list with all Monitors in the database
        try{
            return monitorRepository.findAll();
        }catch( Exception e ){

            throw e;
        }
    }

    public Monitor getMonitorById( Long id ) { // returns the Monitor with the requested ID or an exception if it does not exist
        try{
            return monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
        }catch( Exception e ){

            throw e;
        }
    }

    public Monitor createMonitor(Monitor monitor) { // creates a new Monitor in the database
        try{
            return monitorRepository.save(monitor);
        }catch( Exception e ){

            throw e;
        }
    }

    public void deleteMonitor( Long id ) { // deletes the Monitor with the requested ID or an exception if it does not exist
        try{
            Monitor monitor = monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
            monitorRepository.delete(monitor);
        }catch( Exception e ){

            throw e;
        }
    }


}
