package com.yawolart.notification;

public class EmailService implements NotificationService {
    @Override
    public void notification() {
        System.out.println("Email sent");
    }
}
