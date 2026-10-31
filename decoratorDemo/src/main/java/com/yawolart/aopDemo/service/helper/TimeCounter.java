package com.yawolart.aopDemo.service.helper;

public class TimeCounter {

    private static long startTime;

    public static void startCounting()
    {
        startTime = System.currentTimeMillis();
    }

    public static void stopCounting()
    {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("[TIMECOUNTER] Execution Time: " + duration + "milliseconds");
    }


}
