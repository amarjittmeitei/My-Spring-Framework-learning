package com.yawolart.filterDemo.filters;

import jakarta.servlet.*;
import java.io.IOException;

public class ManualBeanFilterDemo implements Filter {
    @Override
    public void doFilter (
            ServletRequest req,
            ServletResponse resp,
            FilterChain chain
    ) throws IOException, ServletException
    {
        System.out.println("[ManualFilterDemo] nothing is done here");
        chain.doFilter(req,resp);
        System.out.println("[ManualFilterDemo] nothing is done here");
    }

}
