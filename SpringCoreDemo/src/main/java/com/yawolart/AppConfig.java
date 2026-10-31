package com.yawolart;

import com.yawolart.notification.EmailNotification;
import com.yawolart.notification.NotificationService;
import com.yawolart.notification.SmsNotification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.yawolart")
public class AppConfig {

    @Bean
    NotificationService notification()
    {
        return new SmsNotification();
    }

}
