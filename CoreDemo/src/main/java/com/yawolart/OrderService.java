package com.yawolart;

import com.yawolart.notification.*;

public class OrderService {
    //Notification notify = new EmailService(); -> tightly coupling
    NotificationService notify;


    public OrderService(NotificationService notify) {
        this.notify = notify;
    }

    public OrderService(){}

    //setter
    public void setNotify(NotificationService notify) {
        this.notify = notify;
    }

    public void placeOrder()
    {
        System.out.println("Order placed");
        notify.notification();
    }

}
