package com.yawolart.aopDemo.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPointcuts {

    @Pointcut("execution(* com.yawolart.aopDemo.service.StudentService.createStudent(..))")
    public void logCreateStudentPointcutMethod() {}
}
