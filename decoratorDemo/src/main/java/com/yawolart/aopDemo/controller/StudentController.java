package com.yawolart.aopDemo.controller;

import com.yawolart.aopDemo.repository.StudentRepository;
import com.yawolart.aopDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aoptest")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<String> getController(@RequestBody StudentRepository student)
    {
        studentService.createStudent();
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body("DONE");
    }

}
