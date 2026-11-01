package com.yawolart.aopDemo.aspect;

import com.yawolart.aopDemo.customAnnotation.CustomConfiguredAnnotation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class OtherDesignators {

    //intercepting the whole class
    @Before(value = "within(com.yawolart.aopDemo.service.DemoServiceWithin)")
    public void targetDesignatorMethod()
    {
        System.out.println("[OtherDesignators] DemoServiceWithin class intercepted(before");
    }

    @Before(value = "@annotation(com.yawolart.aopDemo.customAnnotation." +
            "CustomMarkerAnnotation)")
    public void annotationDesignatorBeforeMethodA()
    {
        System.out.println("[OtherDesignators] DemoServiceAnnotation." +
                "demoPutServiceA(before) method intercepted");
    }

    @Before(value = "@annotation(customConfiguredAnnotation)")
    public void annotationDesignatorAfterMethodA(
            CustomConfiguredAnnotation customConfiguredAnnotation
    )
    {
        System.out.println("[OtherDesignators] DemoServiceAnnotation." +
                "demoPutServiceA(before) method intercepted: " +
                customConfiguredAnnotation.elementA());
    }
}
