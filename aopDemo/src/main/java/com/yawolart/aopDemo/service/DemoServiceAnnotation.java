package com.yawolart.aopDemo.service;

import com.yawolart.aopDemo.customAnnotation.CustomConfiguredAnnotation;
import com.yawolart.aopDemo.customAnnotation.CustomMarkerAnnotation;
import org.springframework.stereotype.Service;

//Class made just to intercepted by the @annotaion designator
@Service
public class DemoServiceAnnotation {

    @CustomMarkerAnnotation
    public String demoPutServiceA()
    {
        System.out.println("[DemoServiceAnnotation] demoPutServiceA");
        return "Done (annotation - A)";
    }

    @CustomConfiguredAnnotation(elementA = "value modified")
    public String demoPutServiceB()
    {
        System.out.println("[DemoServiceAnnotation] demoPutServiceB");
        return "Done (annotation - B)";
    }
}
