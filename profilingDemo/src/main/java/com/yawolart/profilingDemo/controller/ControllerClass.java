package com.yawolart.profilingDemo.controller;

import com.yawolart.profilingDemo.service.notification.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class ControllerClass {
    NotificationService notificationService;

    public ControllerClass(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @GetMapping
    public ResponseEntity<String> getCall()
    {
        return ResponseEntity.ok(notificationService.send());
    }
}
