package com.yawolart.filterDemo.controller;

import com.yawolart.filterDemo.service.ServiceClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filtertest")
public class ControllerClass {

    ServiceClass serviceClass;

    public ControllerClass(ServiceClass serviceClass) {
        this.serviceClass = serviceClass;
    }


    @GetMapping
    public ResponseEntity<String> getControl()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(serviceClass.getService());
    }
}
