package com.yawolart.crudDtoDemo.entity;

//POJO entity class

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment id
    private long id;
    private String name;
    private int age;
    private String email;
    private int rollno;
    private String subject;
    private boolean deleted;
    private LocalDateTime createdAt; // new added
    private LocalDateTime updatedAt; // new added



    public long getId() {
        return id;
    }

    public Student setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getRollno() {
        return rollno;
    }

    public Student setRollno(int rollno) {
        this.rollno = rollno;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Student setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Student setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Student setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Student setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void studentPrint()
    {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.id);
        System.out.println(this.rollno);
        System.out.println(this.email);
        System.out.println(this.subject);
    }
}
