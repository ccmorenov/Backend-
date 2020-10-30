package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Keyboard;
import com.SE2.EasyPC.dataAccess.repository.KeyboardRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic layer for Keyboard, recives calls from KeyboardController and calls KeyboardRepository
@Service
public class KeyboardService {
    
    @Autowired
    KeyboardRepository keyboardRepository; 

    public List<Keyboard> getAllKeyboards() { // returns a list with all Keyboards in the database
        try{
            return keyboardRepository.findAll();
        }catch( Exception e ){

            throw e;
        }
    }

    public Keyboard getKeyboardById( Long id ) { // returns the Keyboard with the requested ID or an exception if it does not exist
        try{
            return keyboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyboard", "id", id));
        }catch( Exception e ){

            throw e;
        }
    }

    public Keyboard createKeyboard(Keyboard keyboard) { // creates a new Keyboard in the database
        try{
            return keyboardRepository.save(keyboard);
        }catch( Exception e ){

            throw e;
        }
    }

    public void deleteKeyboard( Long id ) { // deletes the Keyboard with the requested ID or an exception if it does not exist
        try{
            Keyboard keyboard = keyboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyboard", "id", id));
            keyboardRepository.delete(keyboard);
        }catch( Exception e ){

            throw e;
        }
    }

}
