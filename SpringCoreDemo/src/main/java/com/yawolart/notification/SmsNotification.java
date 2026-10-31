package com.yawolart.notification;

import org.springframework.stereotype.Component;

public class SmsNotification implements NotificationService{
    @Override
    public void pushNotification() {
        System.out.println("Sms notification ");
    }
}
