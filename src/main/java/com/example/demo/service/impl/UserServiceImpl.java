package com.example.demo.service.impl;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

private final UserRepository userRepository;
private final JwtTokenProvider jwtTokenProvider;

// Constructor injection (REQUIRED)
public UserServiceImpl(UserRepository userRepository,
JwtTokenProvider jwtTokenProvider) {
this.userRepository = userRepository;
this.jwtTokenProvider = jwtTokenProvider;
}

// ================= REGISTER =================
@Override
public AuthResponse registerUser(RegisterRequest request) {

if (userRepository.existsByEmail(request.getEmail())) {
throw new IllegalArgumentException("Email already exists");
}

User user = new User();
user.setName(request.getName());
user.setEmail(request.getEmail());
user.setRoles(request.getRoles());

// ✅ Plain text password (NO security dependency)
user.setPassword(request.getPassword());

User savedUser = userRepository.save(user);

String token = jwtTokenProvider.createToken(
savedUser.getId(),
savedUser.getEmail(),
savedUser.getRoles()
);

return new AuthResponse(token);
}

// ================= LOGIN =================
@Override
public AuthResponse loginUser(LoginRequest request) {

User user = userRepository.findByEmail(request.getEmail())
.orElseThrow(() -> new NoSuchElementException("User not found"));

// ✅ Plain text password comparison
if (!user.getPassword().equals(request.getPassword())) {
throw new IllegalArgumentException("Invalid credentials");
}

String token = jwtTokenProvider.createToken(
user.getId(),
user.getEmail(),
user.getRoles()
);

return new AuthResponse(token);
}
}