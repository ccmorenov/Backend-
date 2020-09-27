package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.RAM;
import com.SE2.EasyPC.dataAccess.repository.RAMRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RAMService {
    
    @Autowired
    RAMRepository ramRepository; 

    public List<RAM> getAllRAMs() {
        return ramRepository.findAll();
    }

    public RAM getRAMById( Long id ) {
        return ramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RAM", "id", id));
    }

    public RAM createRAM(RAM ram) {
        return ramRepository.save(ram);
    }

    public void deleteRAM( Long id ) {
        RAM ram = ramRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RAM", "id", id));
        ramRepository.delete(ram);
    }
}
