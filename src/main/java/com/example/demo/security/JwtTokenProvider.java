package com.example.demo.security;

import java.util.Set;

/**
 * Dummy JWT provider to satisfy test compilation.
 */
public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        return "DUMMY_TOKEN";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String getEmail(String token) {
        return "dummy@email.com";
    }

    public Set<String> getRoles(String token) {
        return Set.of("USER");
    }

    public Long getUserId(String token) {
        return 1L;
    }
}
