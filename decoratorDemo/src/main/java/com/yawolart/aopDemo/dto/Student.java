package com.yawolart.aopDemo.dto;

public class Student {
    private String name;
    private int rollno;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getRollno() {
        return rollno;
    }

    public Student setRollno(int rollno) {
        this.rollno = rollno;
        return this;
    }
}
