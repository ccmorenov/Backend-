package com.SE2.EasyPC.service;

import java.util.List;

import com.SE2.EasyPC.dataAccess.model.User;
import com.SE2.EasyPC.dataAccess.repository.UserRepository;
import com.SE2.EasyPC.exception.ResourceNotFoundException;
import com.SE2.EasyPC.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository; 

    public List<User> getAllUsers() {
        try{
            return userRepository.findAll();
        }catch( Exception e ){
            Log.createLog(3, "Service getAllUsers failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public User getUserById( Long id ) {
        try{
            return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        }catch( Exception e ){
            Log.createLog(3, "Service getUserById failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public User createUser(User user) {
        try{
            return userRepository.save(user);
        }catch( Exception e ){
            Log.createLog(3, "Service createUser failed: " + e.getMessage() );
            throw e;
        }
        
    }

    public void deleteUser( Long id ) {
        try{
            User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
            userRepository.delete(user);
        }catch( Exception e ){
            Log.createLog(3, "Service deleteUser failed: " + e.getMessage() );
            throw e;
        }
        
    }
}
