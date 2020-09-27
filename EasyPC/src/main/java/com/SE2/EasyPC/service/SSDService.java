package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.SSD;
import com.SE2.EasyPC.dataAccess.repository.SSDRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SSDService {

    @Autowired
    SSDRepository ssdRepository; 

    public List<SSD> getAllSSDs() {
        return ssdRepository.findAll();
    }

    public SSD getSSDById( Long id ) {
        return ssdRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SSD", "id", id));
    }

    public SSD createSSD(SSD ssd) {
        return ssdRepository.save(ssd);
    }

    public void deleteSSD( Long id ) {
        SSD ssd = ssdRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SSD", "id", id));
        ssdRepository.delete(ssd);
    }
}
