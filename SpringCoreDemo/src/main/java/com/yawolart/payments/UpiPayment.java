package com.yawolart.payments;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("up")
public class UpiPayment implements PaymentService{
    @Override
    public void payment() {
        System.out.println("Paid via UPI");
    }
}
