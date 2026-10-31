package com.yawolart.springBootCrudDemo.controller;

import com.yawolart.springBootCrudDemo.entity.Student;
import com.yawolart.springBootCrudDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // its also a Component inside it
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //c - create
    /* returning entity class, we cannot set the status code*/
//    @PostMapping
//    public Student create(@RequestBody Student student) // this auto map the JSON to student pojo
//    {
//        System.out.println(student.getEmail());
//        System.out.println(student.getName());
//        Student respStudent = new Student();
//        respStudent = studentService.addedStudent(student);
//        System.out.println("Contreller test: " + respStudent.getEmail());
//        return respStudent;
//
//    }


    /* So instead of returning the entity class
    * return the ResponseEntity<Entity_class>*/
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student)
    {
        student.studentPrint();
        System.out.println("===============================");
        Student respStudent = new Student();
        respStudent = studentService.createStudentService(student);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respStudent);
    }

    //r - read
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id)
    {
        Optional<Student> respStudent;
        respStudent = studentService.getStudentService(id);

        if(respStudent.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(respStudent.get());


        /*Optional functional style expression*/
//        return respStudent
//                .map(student -> ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(student))
//                .orElseGet(() -> ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body(null));
    }


    //u - update
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,
                                                 @RequestBody Student student)
    {
        System.out.println("updateStudent");
        Student respStudent = new Student();
        respStudent = studentService.updateStudentService(id,student);

        if(respStudent == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(respStudent);
    }

    //d - delete (hard)
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable long id)
    {
        boolean resp ;
        resp = studentService.deleteStudentService(id);
        if(!resp)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(" deleted: "+id);
    }

    //delete (soft)
    //using request parameter instead of path variable
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> softDeleteStudent(@RequestParam long id)
    {
        boolean resp;
        resp = studentService.softDeleteStudentService(id);
        if(!resp)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Soft deleted: "+id);
    }

}
