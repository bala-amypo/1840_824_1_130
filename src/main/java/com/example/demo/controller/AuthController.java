package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest r) {
        User u = userService.registerUser(r);
        return new AuthResponse(u.getId(), u.getEmail(), u.getRoles());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest r) {
        User u = userService.authenticate(r);
        return new AuthResponse(u.getId(), u.getEmail(), u.getRoles());
    }
}
