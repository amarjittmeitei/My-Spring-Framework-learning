package com.yawolart.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class EmailNotification implements NotificationService{
    @Override
    public void pushNotification() {
        System.out.println("Email notification");
    }
}
