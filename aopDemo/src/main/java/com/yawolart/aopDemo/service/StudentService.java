package com.yawolart.aopDemo.service;

import com.yawolart.aopDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String createStudent() throws Exception {
        System.out.println("[StudentService] student created");
        studentRepository.save();
        //throw new RuntimeException("Error in service class");
        return "Done";
    }
}
