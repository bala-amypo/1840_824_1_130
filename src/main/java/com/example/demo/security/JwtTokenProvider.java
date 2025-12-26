package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY = "secret";

    public String createToken(Long userId, String email, Set<String> roles) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("roles", roles)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        return true;
    }

    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Set<String> getRoles(String token) {
        return new HashSet<>((List<String>) getClaims(token).get("roles"));
    }

    public Long getUserId(String token) {
        return ((Number) getClaims(token).get("userId")).longValue();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
