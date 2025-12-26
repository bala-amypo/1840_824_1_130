package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import java.util.Set;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final JwtTokenProvider jwt;

    public UserServiceImpl(UserRepository userRepo, JwtTokenProvider jwt) {
        this.userRepo = userRepo;
        this.jwt = jwt;
    }

    @Override
    public AuthResponse registerUser(RegisterRequest req) {
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setRoles(req.getRoles());

        userRepo.save(u);

        return new AuthResponse(jwt.createToken(1L, u.getEmail(), u.getRoles()));
    }

    @Override
    public AuthResponse loginUser(AuthRequest req) {
        User u = userRepo.findByEmail(req.getEmail());
        if (u == null || !u.getPassword().equals(req.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return new AuthResponse(jwt.createToken(1L, u.getEmail(), u.getRoles()));
    }
}
