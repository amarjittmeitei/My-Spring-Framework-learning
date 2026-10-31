package com.yawolart.profilingDemo.service.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Profile("prod")
public class NotificationServiceImplement implements NotificationService{

    @Value("${app.msg}")
    private String msg;

    @Override
    public String send() {
        return msg;
    }
}
