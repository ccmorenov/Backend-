package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.HDD;
import com.SE2.EasyPC.dataAccess.repository.HDDRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HDDService {
    
    @Autowired
    HDDRepository hddRepository; 

    public List<HDD> getAllHDDs() {
        return hddRepository.findAll();
    }

    public HDD getHDDById( Long id ) {
        return hddRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("HDD", "id", id));
    }

    public HDD createHDD(HDD hdd) {
        return hddRepository.save(hdd);
    }

    public void deleteHDD( Long id ) {
        HDD hdd = hddRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("HDD", "id", id));
        hddRepository.delete(hdd);
    }

}
