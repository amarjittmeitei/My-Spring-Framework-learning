package com.yawolart.crudDtoDemo.controller;


import com.yawolart.crudDtoDemo.service.StudentService;
import com.yawolart.crudDtoDemo.dto.CreateReqStudentDto;
import com.yawolart.crudDtoDemo.dto.CreateRespStudentDto;
import com.yawolart.crudDtoDemo.dto.UpdateReqStudentDto;
import com.yawolart.crudDtoDemo.dto.UpdateRespStudentDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // its also a Component inside it
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateRespStudentDto> create(
            @Valid
            @RequestBody CreateReqStudentDto createReqStudentDto)
    {
        CreateRespStudentDto respStudent = new CreateRespStudentDto();
        respStudent = studentService.createStudentService(createReqStudentDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(respStudent);
    }

    //r - read
    @GetMapping()
    public ResponseEntity<CreateRespStudentDto> getStudent(@RequestParam long id)
    {
        CreateRespStudentDto respStudentDto;
        respStudentDto = studentService.getStudentService(id);
        return ResponseEntity.ok(respStudentDto);

    }


    //u - update
    @PutMapping()
    public ResponseEntity<UpdateRespStudentDto> updateStudent(
            @RequestParam long id,
            @Valid
            @RequestBody UpdateReqStudentDto updateReqStudentDto)
    {

        UpdateRespStudentDto respStudentDto = studentService.updateStudentService(
                id,
                updateReqStudentDto);
        return ResponseEntity.ok(respStudentDto);
    }

    //d - delete (hard)
    @DeleteMapping()
    public ResponseEntity<String> deleteStudent (@RequestParam long id)
    {
        boolean resp = studentService.deleteStudentService(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    //delete (soft)
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> softDeleteStudent(@RequestParam long id)
    {
        boolean resp = studentService.softDeleteStudentService(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
