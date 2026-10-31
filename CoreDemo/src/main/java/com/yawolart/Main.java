package com.yawolart;

import com.yawolart.notification.EmailService;
import com.yawolart.notification.NotificationService;
import com.yawolart.notification.SmsService;

import javax.management.Notification;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //when OrderService create its own Obj. for NotificationService
        //but this structure is tightly couple
        //OrderService order = new OrderService();

        //now injecting NotificationService dependency from main to
        //OrderService via constructor
        NotificationService notification = new EmailService();
        OrderService order = new OrderService(notification);
        order.placeOrder();

        //or via setter
        NotificationService notification2 = new SmsService();
        OrderService order2 = new OrderService();
        order2.setNotify(notification2);
        order2.placeOrder();
    }
}