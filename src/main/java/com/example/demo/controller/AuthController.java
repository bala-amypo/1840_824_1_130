package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class AuthController {
    private final UserRepository repo;
    private final PasswordEncoderStub pw;
    private final JwtTokenProvider provider;

    public AuthController(UserRepository repo, PasswordEncoderStub pw, JwtTokenProvider provider) {
        this.repo = repo;
        this.pw = pw;
        this.provider = provider;
    }

    public ResponseEntity<?> register(RegisterRequest r) {
        if (repo.findByEmail(r.getEmail()).isPresent()) return ResponseEntity.status(409).build();
        User u = new User();
        u.setEmail(r.getEmail());
        u.setPassword(pw.encode(r.getPassword()));
        u.setRoles(r.getRoles());
        u.setName(r.getName());
        u.setId(1L);
        repo.save(u);
        AuthResponse resp = new AuthResponse();
        resp.setToken(provider.createToken(u.getId(), u.getEmail(), u.getRoles()));
        return ResponseEntity.ok(resp);
    }

    public ResponseEntity<?> login(AuthRequest r) {
        Optional<User> uOpt = repo.findByEmail(r.getEmail());
        if (uOpt.isEmpty() || !pw.matches(r.getPassword(), uOpt.get().getPassword())) return ResponseEntity.status(401).build();
        User u = uOpt.get();
        AuthResponse resp = new AuthResponse();
        resp.setToken(provider.createToken(u.getId(), u.getEmail(), u.getRoles()));
        return ResponseEntity.ok(resp);
    }
}
