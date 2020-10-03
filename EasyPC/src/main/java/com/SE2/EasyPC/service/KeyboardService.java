package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Keyboard;
import com.SE2.EasyPC.dataAccess.repository.KeyboardRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyboardService {
    
    @Autowired
    KeyboardRepository keyboardRepository; 

    public List<Keyboard> getAllKeyboards() {
        try{
            return keyboardRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllKeyboards failed: " + e.getMessage() );
            throw e;
        }
    }

    public Keyboard getKeyboardById( Long id ) {
        try{
            return keyboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyboard", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getKeyboardById failed: " + e.getMessage() );
            throw e;
        }
    }

    public Keyboard createKeyboard(Keyboard keyboard) {
        try{
            return keyboardRepository.save(keyboard);
        }catch( Exception e ){
            Log.createLog(3, "Service createKeyboard failed: " + e.getMessage() );
            throw e;
        }
    }

    public void deleteKeyboard( Long id ) {
        try{
            Keyboard keyboard = keyboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyboard", "id", id));
            keyboardRepository.delete(keyboard);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteKeyboard failed: " + e.getMessage() );
            throw e;
        }
    }

}
