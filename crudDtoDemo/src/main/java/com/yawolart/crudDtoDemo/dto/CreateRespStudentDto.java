package com.yawolart.crudDtoDemo.dto;

import java.time.LocalDateTime;

public class CreateRespStudentDto {
    private long id;
    private String name;
    private int age;
    private String email;
    private int rollno;
    private String subject;
    LocalDateTime createdAt; // new added
    String message;

    public long getId() {
        return id;
    }

    public CreateRespStudentDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateRespStudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public CreateRespStudentDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateRespStudentDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getRollno() {
        return rollno;
    }

    public CreateRespStudentDto setRollno(int rollno) {
        this.rollno = rollno;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CreateRespStudentDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public CreateRespStudentDto setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CreateRespStudentDto setMessage(String message) {
        this.message = message;
        return this;
    }
}

