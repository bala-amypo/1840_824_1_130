package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User authenticate(AuthRequest request);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User updatedUser);
}
