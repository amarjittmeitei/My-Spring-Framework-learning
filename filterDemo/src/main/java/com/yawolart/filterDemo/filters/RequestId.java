package com.yawolart.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class RequestId implements Filter {
    @Override
    public void doFilter(
            ServletRequest req,
            ServletResponse resp,
            FilterChain chain
    ) throws IOException, ServletException
    {
        //HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;

        String requestId = UUID.randomUUID().toString();
        httpResp.addHeader("x-request-id",requestId);
        System.out.println("[RequestID filter] Request ID: " + requestId);

        try{
            chain.doFilter(req,resp);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
