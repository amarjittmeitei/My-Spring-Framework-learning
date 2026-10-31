package com.yawolart.filterDemo.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    public String getService()
    {
        //just a dummy service class to demonstrate filter in spring boot
        System.out.println("[Service] getService method executed");
        return "{\n" +
                "    \"message\" : \"getService done\"\n" +
                "}";
    }
}
