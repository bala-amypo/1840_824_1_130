package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private Map<Long, User> users = new HashMap<>();

    @Override
    public User updateUser(Long id, User updatedUser) {
        User u = users.get(id);
        if (u != null) {
            u.setName(updatedUser.getName());
            u.setEmail(updatedUser.getEmail());
            u.setPassword(updatedUser.getPassword());
            u.setRoles(updatedUser.getRoles());
        }
        return u;
    }

    @Override
    public User getUserById(Long id) {
        return users.get(id);
    }
}
