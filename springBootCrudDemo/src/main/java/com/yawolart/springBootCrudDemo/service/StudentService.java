package com.yawolart.springBootCrudDemo.service;

import com.yawolart.springBootCrudDemo.entity.Student;
import com.yawolart.springBootCrudDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudentService(Student student)
    {
        Optional<Student> checkStudent =
                studentRepository.findById(student.getId());
        if(checkStudent.isPresent())
            return null;

        //force setting deleted to false when created
        student.setDeleted(false);
        Student addedStudent = new Student();
        //addedStudent = studentRepository.addToDb(student);
        addedStudent = studentRepository.save(student);
        System.out.println("Service test: " + addedStudent.getName());
        return addedStudent;
    }

    public Optional<Student> getStudentService(long id)
    {
        Optional<Student> respStudent;
        respStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        return respStudent;
    }

    public Student updateStudentService(long id, Student reqStudent)
    {
        Optional<Student> respStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if(respStudent.isEmpty()) {
            return null;
        }
        Student updateStudent = respStudent.get();

        updateStudent.setName(reqStudent.getName());
        updateStudent.setEmail(reqStudent.getEmail());
        updateStudent.setSubject(reqStudent.getSubject());
        updateStudent.setAge(reqStudent.getAge());
        updateStudent.setRollno(reqStudent.getRollno());
        return studentRepository.save(updateStudent);
    }

    public boolean deleteStudentService(long id)
    {
        Optional<Student> studentCheck = studentRepository.findById(id);
        if(studentCheck.isEmpty())
            return false;
        studentRepository.deleteById(id);

        studentCheck = studentRepository.findById(id);

        if(studentCheck.isPresent())
            return false;

        return true;

    }

    public boolean softDeleteStudentService(long id)
    {
        Optional<Student> student =
                studentRepository.findByIdAndDeletedIsFalse(id);
        if(student.isEmpty())
            return false;
        student.get().setDeleted(true);
        studentRepository.save(student.get());
        return true;
    }
}
