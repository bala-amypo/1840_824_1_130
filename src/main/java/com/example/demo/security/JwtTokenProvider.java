package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JwtTokenProvider {

public String createToken(Long userId, String email, Set<String> roles) {
// SIMPLE stub token (enough to compile & run)
return "dummy-jwt-token-for-" + email;
}
}
