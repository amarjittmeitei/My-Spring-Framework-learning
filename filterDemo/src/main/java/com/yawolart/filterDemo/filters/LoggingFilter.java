package com.yawolart.filterDemo.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(3)
public class LoggingFilter implements Filter {


    @Override
    public void doFilter(
            ServletRequest req,
            ServletResponse resp,
            FilterChain chain
    ) throws IOException, ServletException {
        //request modification area
        //if we need to some header for to response we should add here as
        //response cannot modify
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;

        long reqReceivedTime = System.currentTimeMillis();

        System.out.println("[Logging Filter] Incoming request: "+
                httpReq.getMethod()+" "+
                httpReq.getRequestURI()
        );


        try{
            chain.doFilter(req,resp);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            //response cannot be modified
            //logic need to do after resp is received done here
            System.out.println("[Logging Filter] Response status: " + httpResp.getStatus());
            long processingTime =
                    System.currentTimeMillis() - reqReceivedTime;
            System.out.println("[Logging Filter] Response Time: " + processingTime);

        }




    }
}
