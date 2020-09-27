package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Keyboard;
import com.SE2.EasyPC.dataAccess.repository.KeyboardRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyboardService {
    
    @Autowired
    KeyboardRepository keyboardRepository; 

    public List<Keyboard> getAllKeyboards() {
        return keyboardRepository.findAll();
    }

    public Keyboard getKeyboardById( Long id ) {
        return keyboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyboard", "id", id));
    }

    public Keyboard createKeyboard(Keyboard keyboard) {
        return keyboardRepository.save(keyboard);
    }

    public void deleteKeyboard( Long id ) {
        Keyboard keyboard = keyboardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Keyboard", "id", id));
        keyboardRepository.delete(keyboard);
    }

}
