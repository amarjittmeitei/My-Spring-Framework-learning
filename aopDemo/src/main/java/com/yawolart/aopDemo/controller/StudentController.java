package com.yawolart.aopDemo.controller;

import com.yawolart.aopDemo.service.DemoServiceAnnotation;
import com.yawolart.aopDemo.service.DemoServiceWithin;
import com.yawolart.aopDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aoptest")
public class StudentController {

    StudentService studentService;
    DemoServiceWithin demoServiceWithin;
    DemoServiceAnnotation demoServiceAnnotation;

    public StudentController(
            StudentService studentService,
            DemoServiceWithin demoServiceWithin,
            DemoServiceAnnotation demoServiceAnnotation) {
        this.studentService = studentService;
        this.demoServiceWithin = demoServiceWithin;
        this.demoServiceAnnotation = demoServiceAnnotation;
    }

    @PostMapping
    public ResponseEntity<String> postController() throws Exception {
        String s = studentService.createStudent();
        return ResponseEntity.ok(s);
    }

    @PutMapping
    public ResponseEntity<String> putController(@RequestParam int mode){

        String returnString;

        if(mode == 1) {
            returnString = demoServiceWithin.demoPutService();
        } else if (mode == 2) {
            returnString = demoServiceAnnotation.demoPutServiceA();
        } else if (mode == 3) {
            returnString = demoServiceAnnotation.demoPutServiceB();

        } else
            returnString = "Default Response";

        return ResponseEntity.ok(returnString);
    }
}
