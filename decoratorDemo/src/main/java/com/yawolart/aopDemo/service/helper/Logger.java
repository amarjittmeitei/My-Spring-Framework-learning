package com.yawolart.aopDemo.service.helper;

public class Logger {
    static public void startLog(
            String className,
            String methodName
    ){

        System.out.println("[LOGGER] Executing ---> " +
                "Class name: " + className +
                ", Method name: " + methodName);
    }

    static public void endLog(
            String className,
            String methodName
    ){

        System.out.println("[LOGGER] Done Execution ---> " +
                "Class name: " + className +
                ", Method name: " + methodName);
    }
}
