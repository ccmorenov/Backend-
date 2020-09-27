package com.SE2.EasyPC.service;


import java.util.List;

import com.SE2.EasyPC.dataAccess.model.CPU;
import com.SE2.EasyPC.dataAccess.repository.CPURepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPUService {
    
    @Autowired
    CPURepository cpuRepository; 

    public List<CPU> getAllCPUs() {
        return cpuRepository.findAll();
    }

    public CPU getCPUById( Long id ) {
        return cpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CPU", "id", id));
    }

    public CPU createCPU(CPU cpu) {
        return cpuRepository.save(cpu);
    }

    public void deleteCPU( Long id ) {
        CPU cpu = cpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CPU", "id", id));
        cpuRepository.delete(cpu);
    }

}