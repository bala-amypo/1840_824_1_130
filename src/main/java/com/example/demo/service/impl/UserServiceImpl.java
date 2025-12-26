package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final JwtTokenProvider jwt;

    public UserServiceImpl(UserRepository userRepo, JwtTokenProvider jwt) {
        this.userRepo = userRepo;
        this.jwt = jwt;
    }

    @Override
    public AuthResponse registerUser(RegisterRequest req) {
        // Create user entity
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setRoles(req.getRoles() != null ? req.getRoles() : new HashSet<>());

        userRepo.save(u);

        // Generate a dummy token (since real JWT support is stubbed)
        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse loginUser(AuthRequest req) {
        User u = userRepo.findByEmail(req.getEmail());
        if (u == null || !u.getPassword().equals(req.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return new AuthResponse(token);
    }
}
