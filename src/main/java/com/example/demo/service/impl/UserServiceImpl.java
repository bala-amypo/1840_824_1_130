package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(RegisterRequest req) {
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword()); // In real app: hash password
        u.setRoles(req.getRoles());

        userRepository.save(u);
        return u;
    }

    @Override
    public User authenticate(AuthRequest req) {
        User u = userRepository.findByEmail(req.getEmail());
        if (u != null && u.getPassword().equals(req.getPassword())) {  // simple password check
            return u;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
