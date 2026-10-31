package com.yawolart.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest req,
            ServletResponse resp,
            FilterChain chain
    ) throws IOException, ServletException
    {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;
        System.out.println("===============================");

        String token = httpReq.getHeader("token");

        if(token == null || !token.equals("12345"))
        {
            System.out.println("\t[Authentication Filter] Unauthorized user!");
            httpResp.setContentType("application/json");
            httpResp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResp.getWriter().write("{\n" +
                    "    \"access\" : \"denied\",\n" +
                    "    \"reason\" : \"unauthorized user\"\n" +
                    "}");
            return;
        }

        try {
            chain.doFilter(req,resp);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("[Authentication Filter] Authorized user");

    }
}
