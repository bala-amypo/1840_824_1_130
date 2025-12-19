package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.User;

public interface UserService


{
    public User registerUser(User req);
    public User loginUser(User req);
}