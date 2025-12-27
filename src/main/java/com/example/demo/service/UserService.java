package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;

public interface UserService {
    User registerUser(RegisterRequest req);
    User authenticate(AuthRequest req);
}
