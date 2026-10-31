package com.yawolart.springBootDemo;

import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {
    final private PaymentProperties paymentProperties;


    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType()
    {
        return paymentProperties.getType();
    }

    public int getRetryCount()
    {
        return paymentProperties.getRetryCount();
    }

    public boolean isEnable()
    {
        return paymentProperties.isEnable();
    }

    public long getTimeout()
    {
        return paymentProperties.getTimeout();
    }

    public void printProperties()
    {
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(isEnable());
        System.out.println(getTimeout());
    }


}
