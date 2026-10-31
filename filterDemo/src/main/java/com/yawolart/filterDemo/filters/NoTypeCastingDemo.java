package com.yawolart.filterDemo.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class NoTypeCastingDemo extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse resp,
            FilterChain chain
    )throws IOException, ServletException {
        System.out.println("[NoTypeCastingDemo] Nothing is done here");
        chain.doFilter(req,resp);
        System.out.println("[NoTypeCastingDemo] Nothing is done here");
    }
}
