package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.GPU;
import com.SE2.EasyPC.dataAccess.repository.GPURepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPUService {
    
    @Autowired
    GPURepository gpuRepository; 

    public List<GPU> getAllGPUs() {
        return gpuRepository.findAll();
    }

    public GPU getGPUById( Long id ) {
        return gpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GPU", "id", id));
    }

    public GPU createGPU(GPU gpu) {
        return gpuRepository.save(gpu);
    }

    public void deleteGPU( Long id ) {
        GPU gpu = gpuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("GPU", "id", id));
        gpuRepository.delete(gpu);
    }

}