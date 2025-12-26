package com.example.demo.security;

import java.util.Set;

/**
 * Compile-safe stub for JwtTokenProvider.
 * Does NOT use real JWT because no JWT library is in pom.xml.
 */
public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        // Return a dummy token string
        return "DUMMY_TOKEN";
    }
}
