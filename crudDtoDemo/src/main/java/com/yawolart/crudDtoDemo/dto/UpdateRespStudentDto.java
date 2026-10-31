package com.yawolart.crudDtoDemo.dto;

import java.time.LocalDateTime;

public class UpdateRespStudentDto {
    private long id;
    private String name;
    private int age;
    private String email;
    private int rollno;
    private String subject;
    LocalDateTime updatedAt; // new added
    String message;

    public long getId() {
        return id;
    }

    public UpdateRespStudentDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdateRespStudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UpdateRespStudentDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateRespStudentDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getRollno() {
        return rollno;
    }

    public UpdateRespStudentDto setRollno(int rollno) {
        this.rollno = rollno;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public UpdateRespStudentDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UpdateRespStudentDto setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UpdateRespStudentDto setMessage(String message) {
        this.message = message;
        return this;
    }
}
