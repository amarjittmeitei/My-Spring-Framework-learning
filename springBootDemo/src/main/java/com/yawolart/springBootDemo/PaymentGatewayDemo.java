package com.yawolart.springBootDemo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Demonstration for @value annotation
@Component
public class PaymentGatewayDemo {
    //@Value("{paymentGatewayDemo.type:NotFound}")
    private String type;
    //@Value("{paymentGatewayDemo.retryCount:-1}")
    private int retryCount;

    public PaymentGatewayDemo(@Value("${paymentGateway-demo.type}") String type,
                              @Value("${paymentGateway-demo.retry-count}") int retryCount){
        this.type = type;
        this.retryCount = retryCount;
    }


    public String getType() {
        return type;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
