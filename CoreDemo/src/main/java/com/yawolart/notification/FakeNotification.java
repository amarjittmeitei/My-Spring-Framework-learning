package com.yawolart.notification;

public class FakeNotification implements NotificationService {
    @Override
    public void notification() {
        System.out.println("Dummy Notification sent");
    }
}
