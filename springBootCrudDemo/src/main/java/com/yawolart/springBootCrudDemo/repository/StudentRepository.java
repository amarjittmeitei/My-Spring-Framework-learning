package com.yawolart.springBootCrudDemo.repository;

import com.yawolart.springBootCrudDemo.entity.Student;
import com.yawolart.springBootCrudDemo.service.StudentService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Long> {
    //it will be implemented by spring boot itself no need to override
    //and implemente the StudentRepository interface to another class
    Optional<Student> findByIdAndDeletedIsFalse(long id);
}

//@Component
//public class StudentRepository {
//    public Student addToDb(Student student)
//    {
//        // add to database
//
//        //for now create a dummy class
//        Student dummyStudent = new Student();
//        dummyStudent.setId(-1);
//        dummyStudent.setAge(-1);
//        dummyStudent.setRollno(-1);
//        dummyStudent.setEmail("dummy email");
//        dummyStudent.setName("dummy name");
//        dummyStudent.setSubject("dummy subject");
//        System.out.println("Repository test: " + dummyStudent.getName());
//
//        return dummyStudent;
//    }
//
//}
