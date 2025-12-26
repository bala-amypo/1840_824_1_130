package com.example.demo.security;

import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Compile-safe stub for JwtTokenProvider.
 * Does not actually perform JWT operations because your pom.xml
 * does not include Spring Security / JWT libraries.
 */
@Component
public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        // Return a dummy string (or “fake token”) — adjust as needed
        return "DUMMY_TOKEN";
    }
}
