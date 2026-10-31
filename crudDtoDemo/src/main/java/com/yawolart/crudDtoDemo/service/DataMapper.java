package com.yawolart.crudDtoDemo.service;

import com.yawolart.crudDtoDemo.entity.Student;
import com.yawolart.crudDtoDemo.dto.CreateReqStudentDto;
import com.yawolart.crudDtoDemo.dto.CreateRespStudentDto;
import com.yawolart.crudDtoDemo.dto.UpdateReqStudentDto;
import com.yawolart.crudDtoDemo.dto.UpdateRespStudentDto;

import java.time.LocalDateTime;

//helper class

public class DataMapper {

    //mapping the createReqStudentDto to new student
    static Student mapToStudent(CreateReqStudentDto createReqStudentDto)
    {
        //this is not the recommended way to map
        //this strategy is error-prone
        //we will replace this later
        Student respStudent = new Student();
        respStudent.setName(createReqStudentDto.getName());
        respStudent.setAge(createReqStudentDto.getAge());
        respStudent.setEmail(createReqStudentDto.getEmail());
        respStudent.setRollno(createReqStudentDto.getRollno());
        respStudent.setSubject(createReqStudentDto.getSubject());
        respStudent.setDeleted(false);
        respStudent.setCreatedAt(LocalDateTime.now());
        respStudent.setUpdatedAt(LocalDateTime.now());
        return respStudent;
    }

    //mapping updateReqStudentDto to existing student
    static Student mapToStudent(Student respStudent,UpdateReqStudentDto updateReqStudentDto)
    {
        respStudent.setName(updateReqStudentDto.getName());
        respStudent.setAge(updateReqStudentDto.getAge());
        respStudent.setRollno(updateReqStudentDto.getRollno());
        respStudent.setSubject(updateReqStudentDto.getSubject());
        respStudent.setUpdatedAt(LocalDateTime.now());
        return respStudent;
    }

    static CreateRespStudentDto mapToCreateRespStudentDto(Student student)
    {
        CreateRespStudentDto respStudentDto = new CreateRespStudentDto();

        respStudentDto.setAge(student.getAge());
        respStudentDto.setCreatedAt(student.getCreatedAt());
        respStudentDto.setId(student.getId());
        respStudentDto.setName(student.getName());
        respStudentDto.setEmail(student.getEmail());
        respStudentDto.setSubject(student.getSubject());
        respStudentDto.setRollno(student.getRollno());
        respStudentDto.setMessage("Student data created");

        return respStudentDto;
    }

    static UpdateRespStudentDto mapToUpdateRespStudentDto(Student student)
    {
        UpdateRespStudentDto respStudentDto = new UpdateRespStudentDto();

        respStudentDto.setAge(student.getAge());
        respStudentDto.setUpdatedAt(student.getUpdatedAt());
        respStudentDto.setId(student.getId());
        respStudentDto.setName(student.getName());
        respStudentDto.setEmail(student.getEmail());
        respStudentDto.setSubject(student.getSubject());
        respStudentDto.setRollno(student.getRollno());
        respStudentDto.setMessage("Student data updated");

        return respStudentDto;
    }


}
