package com.example.demo.service;


import com.example.demo.model.User;
import java.util.List;

public interface UserService


{
    public User registerUser(User req);
    public User loginUser(User req);
}