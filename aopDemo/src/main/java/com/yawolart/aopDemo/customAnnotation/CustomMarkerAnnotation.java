package com.yawolart.aopDemo.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Marker Annotation -> it doesn't have any elements
//meta annotations -> annotations on a annotation
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomMarkerAnnotation {
}
