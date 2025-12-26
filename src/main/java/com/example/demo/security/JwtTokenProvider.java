package com.example.demo.security;

import java.util.Set;

/**
 * Stubbed token provider — returns a constant string
 * since JWT library isn’t on the classpath.
 */
public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        // Stub: return a placeholder token
        return "DUMMY_TOKEN";
    }
}
