package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.PowerSupply;
import com.SE2.EasyPC.dataAccess.repository.PowerSupplyRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerSupplyService {
     
    @Autowired
    PowerSupplyRepository powerSupplyRepository; 

    public List<PowerSupply> getAllPowerSupplies() {
        return powerSupplyRepository.findAll();
    }

    public PowerSupply getPowerSupplyById( Long id ) {
        return powerSupplyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PowerSupply", "id", id));
    }

    public PowerSupply createPowerSupply(PowerSupply powerSupply) {
        return powerSupplyRepository.save(powerSupply);
    }

    public void deletePowerSupply( Long id ) {
        PowerSupply powerSupply = powerSupplyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PowerSupply", "id", id));
        powerSupplyRepository.delete(powerSupply);
    }
}
