package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Mouse;
import com.SE2.EasyPC.dataAccess.repository.MouseRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MouseService {
        
    @Autowired
    MouseRepository mouseRepository; 

    public List<Mouse> getAllMice() {
        try{
            return mouseRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllMice failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public Mouse getMouseById( Long id ) {
        try{
            return mouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mouse", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getMouseById failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public Mouse createMouse(Mouse mouse) {
        try{
            return mouseRepository.save(mouse);
        }catch( Exception e ){
            Log.createLog(3, "Service createMouse failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public void deleteMouse( Long id ) {
        try{
            Mouse mouse = mouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mouse", "id", id));
            mouseRepository.delete(mouse);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteMouse failed: " + e.getMessage() );
            throw e;
        }
        
    }
}
