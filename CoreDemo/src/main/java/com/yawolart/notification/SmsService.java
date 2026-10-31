package com.yawolart.notification;

public class SmsService implements NotificationService {
    @Override
    public void notification() {
        System.out.println("Sms sent");
    }
}
