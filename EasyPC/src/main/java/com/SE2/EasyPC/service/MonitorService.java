package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Monitor;
import com.SE2.EasyPC.dataAccess.repository.MonitorRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {
    
    @Autowired
    MonitorRepository monitorRepository; 

    public List<Monitor> getAllMonitors() {
        try{
            return monitorRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllMonitors failed: " + e.getMessage() );
            throw e;
        }
    }

    public Monitor getMonitorById( Long id ) {
        try{
            return monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getMonitorById failed: " + e.getMessage() );
            throw e;
        }
    }

    public Monitor createMonitor(Monitor monitor) {
        try{
            return monitorRepository.save(monitor);
        }catch( Exception e ){
            Log.createLog(3, "Service createMonitor failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteMonitor( Long id ) {
        try{
            Monitor monitor = monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
            monitorRepository.delete(monitor);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteMonitor failed: " + e.getMessage() );
            throw e;
        }
    }


}
