package com.SE2.EasyPC.controller;

import com.SE2.EasyPC.dataAccess.model.User;
import com.SE2.EasyPC.service.UserService;
import com.SE2.EasyPC.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers( HttpServletRequest request ) {
        Log.createLog(0, "getAllUsers query received by " + request.getRemoteAddr());
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUsersById(@PathVariable(value = "id") Long userId, HttpServletRequest request ) {
        Log.createLog(0, "getUsersById query received by " + request.getRemoteAddr() );
        return userService.getUserById(userId);
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user, HttpServletRequest request) {
        Log.createLog(0, "createUser query received by " + request.getRemoteAddr() );
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId, HttpServletRequest request) {
        Log.createLog(0, "deleteUser query received by " + request.getRemoteAddr() );
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
