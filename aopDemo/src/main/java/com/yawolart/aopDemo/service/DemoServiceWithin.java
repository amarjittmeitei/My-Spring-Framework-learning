package com.yawolart.aopDemo.service;

import org.springframework.stereotype.Service;

//Class made just to intercept by the point cut expression with within designator
@Service
public class DemoServiceWithin {
    public String demoPutService()
    {
        System.out.println("[DemoServiceWithin] getService");
        return "Done (within)";
    }
}
