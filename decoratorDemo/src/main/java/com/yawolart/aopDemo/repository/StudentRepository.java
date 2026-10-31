package com.yawolart.aopDemo.repository;

import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    public void save()
    {
        System.out.println("[StudentRepository] Student save to db");
    }

}
