package com.yawolart.aopDemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class AroundAdviceDemo {

    //unlike other advices around advice consume the return of targeted method
    //around advice all do all the task of the other advices
    //around advice is a whole wrapper
    @Around(value = "execution(* com.yawolart.aopDemo.service.StudentService.createStudent(..))")
    public Object aroundDemoMethod(ProceedingJoinPoint jointPoint) throws Throwable {
        //this is like the before advice
        System.out.println("[AroundAdviceDemo] Before execution of targeted method");

        try {
            Object obj = jointPoint.proceed();
            System.out.println("[AroundAdviceDemo] After returning targeted method");

            //here the return value can be modified
            String convertedReturnValue = (String) obj;
            String modifiedReturnValue = convertedReturnValue.toUpperCase();
            System.out.println("[AroundAdviceDemo] Original return value: " + obj);
            System.out.println("[AroundAdviceDemo] Modified return value: " + modifiedReturnValue);
            return modifiedReturnValue;
        }
        catch (Throwable ex)
        {
            System.out.println("[AroundAdviceDemo] After throwing exeption by the targeted method");
            throw ex;
            //or can handle it here
        }
        finally {
            System.out.println("[AroundAdviceDemo] After completing the whole execution");
        }
    }
}
