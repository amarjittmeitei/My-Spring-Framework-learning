package com.yawolart.crudDtoDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public class CreateReqStudentDto {
    @NotBlank(message = "name cannot be blank")
    private String name;
    @Min(value = 18, message = "Minimum age is 18")
    private int age;
    @Email(message = "invalid email formate")
    private String email;
    @Min(value = 1,message = "Roll no should greater than or equal to 1")
    private int rollno;
    @NotBlank(message = "subject cannot be blank")
    private String subject;

    public String getName() {
        return name;
    }

    public CreateReqStudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public CreateReqStudentDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateReqStudentDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getRollno() {
        return rollno;
    }

    public CreateReqStudentDto setRollno(int rollno) {
        this.rollno = rollno;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CreateReqStudentDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}
