package com.yawolart.aopDemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    @Before(
       value = "execution(String com.yawolart.aopDemo.service.StudentService.createStudent())")
    public void logBeforeMethod()
    {
        System.out.println("[LoggingAspect] Before advice");

        //anything return here will not reflect to the method caller
        //here, return statement cannot stop the proxy from executing the
        //targeted method

        //to prevent the execution of targeted method, here an Exception needs
        //to be throw
    }

    //wildcard  characters * and .. can be use here
    // * -> Exactly one of anything
    // .. -> Zero or more of anything
    @AfterReturning(
            value = "execution(* com.yawolart.aopDemo.service.StudentService.createStudent(..))",
            returning = "result"
    )
    public void logAfterReturningMethod(String result)
    {
        //this method execute if no exception occur during the execution of
        //the targeted method

        System.out.println("[LoggingAspect] AfterReturning advice");
        //Also, any return statement here will not reflect to the caller
        //Here, it is impossible to prevent execution of targeted method
        //as after returning advice occur after the execution of the
        //targeted method
    }

    @AfterThrowing(
            value = "execution(* com.yawolart.aopDemo.service.StudentService.createStudent(..))",
            throwing = "ex"
    )
    public void logAfterThrowingMethod(RuntimeException ex)
    {
        //this method will execute if any unhandled exception are there
        //during the execution of the targeted method
        //So, this method will never execute of there is no exception throw
        System.out.println("[LoggingAspect] AfterThrowing advice");

        //also the exception ex in our case cannot catch here as catch without
        //try block is illegal.
        //But, we can still play with the exception
        System.out.println("[LoggingAspect] AfterThrowing: "+ex.getMessage());

        //the return statement here will do nothing as before
    }

    @After(value = "execution(* com.yawolart.aopDemo.service.StudentService.createStudent(..))")
    public void logAfterMethod()
    {
        //this method execute for sure after the execution of the main method
        System.out.println("[LoggingAspect] After advice");
        //same as before, the return statement do nothing
    }

}
