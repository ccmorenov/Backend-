package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Cooling;
import com.SE2.EasyPC.dataAccess.repository.CoolingRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoolingService {
    @Autowired
    CoolingRepository coolingRepository; 

    public List<Cooling> getAllCoolings() {
        return coolingRepository.findAll();
    }

    public Cooling getCoolingById( Long id ) {
        return coolingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cooling", "id", id));
    }

    public Cooling createCooling(Cooling cooling) {
        return coolingRepository.save(cooling);
    }

    public void deleteCooling( Long id ) {
        Cooling cooling = coolingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cooling", "id", id));
        coolingRepository.delete(cooling);
    }
}
