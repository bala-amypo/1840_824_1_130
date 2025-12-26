package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.NoSuchElementException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        User u = userRepo.findByEmail(email);
        if (u == null || !u.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return u;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
