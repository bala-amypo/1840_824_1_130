package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthenticationFilter implements Filter {
    private final JwtTokenProvider provider;
    private final CustomUserDetailsService uds;

    public JwtAuthenticationFilter(JwtTokenProvider provider, CustomUserDetailsService uds) {
        this.provider = provider;
        this.uds = uds;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
}
