package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Monitor;
import com.SE2.EasyPC.dataAccess.repository.MonitorRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {
    
    @Autowired
    MonitorRepository monitorRepository; 

    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    public Monitor getMonitorById( Long id ) {
        return monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
    }

    public Monitor createMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public void deleteMonitor( Long id ) {
        Monitor monitor = monitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Monitor", "id", id));
        monitorRepository.delete(monitor);
    }

}
