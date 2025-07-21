package com.foodconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodconnect.model.User;
import com.foodconnect.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Email already exists!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        userRepository.save(user);

        // Prepare response for frontend
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Registration Successful!");
        response.put("token", "dummy-token"); // No JWT, so use dummy token for now
        response.put("user", user);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("token", "dummy-token"); // Same dummy token
            response.put("user", existingUser);
            return ResponseEntity.ok(response);
        }

        Map<String, String> error = new HashMap<>();
        error.put("message", "Invalid Email or Password!");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
