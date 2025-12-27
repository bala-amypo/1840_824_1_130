package com.example.demo.security;

import java.util.Set;
import java.util.Base64;

public class JwtTokenProvider {
    public String createToken(Long id, String email, Set<String> roles) {
        return Base64.getEncoder().encodeToString((id + ":" + email).getBytes());
    }

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }

    public String getEmail(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split(":")[1];
    }

    public Set<String> getRoles(String token) {
        return Set.of("ADMIN");
    }

    public Long getUserId(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return Long.valueOf(decoded.split(":")[0]);
    }
}
