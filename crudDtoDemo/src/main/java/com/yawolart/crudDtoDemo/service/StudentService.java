package com.yawolart.crudDtoDemo.service;


import com.yawolart.crudDtoDemo.entity.Student;
import com.yawolart.crudDtoDemo.exception.DuplicateEmailException;
import com.yawolart.crudDtoDemo.exception.ResourceNotFoundException;
import com.yawolart.crudDtoDemo.exception.UnableToUpdateDbException;
import com.yawolart.crudDtoDemo.repository.StudentRepository;
import com.yawolart.crudDtoDemo.dto.CreateReqStudentDto;
import com.yawolart.crudDtoDemo.dto.CreateRespStudentDto;
import com.yawolart.crudDtoDemo.dto.UpdateReqStudentDto;
import com.yawolart.crudDtoDemo.dto.UpdateRespStudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;
    //DataMapper dataMapper;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public CreateRespStudentDto createStudentService(CreateReqStudentDto createReqStudentDto)
    {
        Student student = DataMapper.mapToStudent(createReqStudentDto);
        if(studentRepository.existsByEmail(createReqStudentDto.getEmail()))
        {
            throw new DuplicateEmailException(
                    "The email:" +createReqStudentDto.getEmail()+ " is already exist."
            );
        }
        Student addedStudent = addedStudent = studentRepository.save(student);
        return DataMapper.mapToCreateRespStudentDto(student);
    }

    public CreateRespStudentDto getStudentService(long id)
    {
        Student respStudent;
        respStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Any data on id:" +id+ " not found"
                ));
        CreateRespStudentDto respStudentDto
                = DataMapper.mapToCreateRespStudentDto(respStudent);
        respStudentDto.setMessage("Student data found");
        return respStudentDto;
    }

    public UpdateRespStudentDto updateStudentService(long id, UpdateReqStudentDto updateReqStudentDto)
    {
        Student checkStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Any data on id:" +id+ " not found"
                ));
        Student linkerStudent = DataMapper.mapToStudent(
                checkStudent,
                updateReqStudentDto);
        Student respStudent = studentRepository.save(linkerStudent);
        return DataMapper.mapToUpdateRespStudentDto(respStudent);


    }

    public boolean deleteStudentService(long id)
    {
        Student studentCheck = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Any data on id:" +id+ " not found"
                ));
        studentRepository.deleteById(id);
        if(studentRepository.findById(id).isPresent())
            throw new UnableToUpdateDbException("Something went wrong while deleting the data");
        return true;

    }

    public boolean softDeleteStudentService(long id)
    {
        Student student = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Any data on id:" +id+ " not found"
                ));
        student.setDeleted(true);
        studentRepository.save(student);
        if(studentRepository.findByIdAndDeletedIsFalse(id).isPresent())
            throw new UnableToUpdateDbException("Something went wrong while deleting the data");
        return true;
    }
}
