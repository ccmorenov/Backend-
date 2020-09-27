package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Motherboard;
import com.SE2.EasyPC.dataAccess.repository.MotherboardRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotherboardService {
    
    @Autowired
    MotherboardRepository motherboardRepository; 

    public List<Motherboard> getAllMotherboards() {
        return motherboardRepository.findAll();
    }

    public Motherboard getMotherboardById( Long id ) {
        return motherboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", id));
    }

    public Motherboard createMotherboard(Motherboard motherboard) {
        return motherboardRepository.save(motherboard);
    }

    public void deleteMotherboard( Long id ) {
        Motherboard motherboard = motherboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Motherboard", "id", id));
        motherboardRepository.delete(motherboard);
    }
}
