package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Mouse;
import com.SE2.EasyPC.dataAccess.repository.MouseRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MouseService {
        
    @Autowired
    MouseRepository mouseRepository; 

    public List<Mouse> getAllMice() {
        return mouseRepository.findAll();
    }

    public Mouse getMouseById( Long id ) {
        return mouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mouse", "id", id));
    }

    public Mouse createMouse(Mouse mouse) {
        return mouseRepository.save(mouse);
    }

    public void deleteMouse( Long id ) {
        Mouse mouse = mouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mouse", "id", id));
        mouseRepository.delete(mouse);
    }
}
