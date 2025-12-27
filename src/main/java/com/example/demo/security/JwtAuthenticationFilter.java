package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider provider;
    private final CustomUserDetailsService userDetailsService;

    // ✅ REQUIRED by test #45
    public JwtAuthenticationFilter(JwtTokenProvider provider,
                                   CustomUserDetailsService uds) {
        this.provider = provider;
        this.userDetailsService = uds;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain)
            throws IOException, ServletException {

        String header = req.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            if (provider.validateToken(token)) {
                var authorities = provider.getRoles(token).stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                var auth = new UsernamePasswordAuthenticationToken(
                        provider.getEmail(token),
                        null,
                        authorities
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(req, res);
    }
}
