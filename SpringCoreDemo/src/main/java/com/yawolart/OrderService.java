package com.yawolart;

import com.yawolart.notification.NotificationService;
import com.yawolart.payments.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    PaymentService paymentService;
    NotificationService notificationService;



    @Autowired  //If there is only one constructor Spring do it by itself
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //@Autowired
    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public OrderService() {
    }

    //@Autowired
    public OrderService(PaymentService paymentService, NotificationService notificationService) {
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }


    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    void placeOrder()
    {
        System.out.println("Order placed");
        paymentService.payment();
        notificationService.pushNotification();
    }

}
