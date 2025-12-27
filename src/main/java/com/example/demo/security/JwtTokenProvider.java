// package com.example.demo.security;

// import java.util.Set;
// import java.util.Base64;

// public class JwtTokenProvider {
//     public String createToken(Long id, String email, Set<String> roles) {
//         return Base64.getEncoder().encodeToString((id + ":" + email).getBytes());
//     }

//     public boolean validateToken(String token) {
//         return token != null && !token.isEmpty();
//     }

//     public String getEmail(String token) {
//         String decoded = new String(Base64.getDecoder().decode(token));
//         return decoded.split(":")[1];
//     }

//     public Set<String> getRoles(String token) {
//         return Set.of("ADMIN");
//     }

//     public Long getUserId(String token) {
//         String decoded = new String(Base64.getDecoder().decode(token));
//         return Long.valueOf(decoded.split(":")[0]);
//     }
// }

package com.example.demo.security;

import java.util.Base64;
import java.util.Set;

public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        String raw = userId + "|" + email + "|" + String.join(",", roles);
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|")[1];
    }

    public Set<String> getRoles(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return Set.of(decoded.split("\\|")[2].split(","));
    }

    public Long getUserId(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return Long.valueOf(decoded.split("\\|")[0]);
    }
}
