package com.yawolart.payments;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cp")
@Primary
public class CardPayment implements PaymentService{
    @Override
    public void payment() {
        System.out.println("Paid by card");
    }
}
