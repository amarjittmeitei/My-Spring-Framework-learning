package com.yawolart.aopDemo.customAnnotation;

import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//Marker Annotation -> it have elements
//meta annotations -> annotations on a annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomConfiguredAnnotation {

    String elementA() default "no values";

    //multiple elements are allowed
}
