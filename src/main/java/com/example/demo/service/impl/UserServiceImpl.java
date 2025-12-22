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

// REQUIRED constructor (order matters for tests)
public UserServiceImpl(UserRepository userRepository,
PasswordEncoder passwordEncoder,
JwtTokenProvider jwtTokenProvider) {
this.userRepository = userRepository;
this.passwordEncoder = passwordEncoder;
this.jwtTokenProvider = jwtTokenProvider;
}

@Override
public AuthResponse registerUser(RegisterRequest request) {

if (userRepository.existsByEmail(request.getEmail())) {
throw new IllegalArgumentException("Email already exists");
}

User user = new User();
user.setName(request.getName());
user.setEmail(request.getEmail());
user.setRoles(request.getRoles());
user.setPassword(passwordEncoder.encode(request.getPassword()));

User saved = userRepository.save(user);

String token = jwtTokenProvider.createToken(
saved.getId(),
saved.getEmail(),
saved.getRoles()
);

return new AuthResponse(token);
}

@Override
public AuthResponse loginUser(AuthRequest request) {

User user = userRepository.findByEmail(request.getEmail())
.orElseThrow(() -> new NoSuchElementException("User not found"));

if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
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
