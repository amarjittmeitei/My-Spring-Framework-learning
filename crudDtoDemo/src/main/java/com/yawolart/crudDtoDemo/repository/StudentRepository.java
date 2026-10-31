package com.yawolart.crudDtoDemo.repository;


import com.yawolart.crudDtoDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Long> {
    //it will be implemented by spring boot itself no need to override
    //and implement the StudentRepository interface to another class
    Optional<Student> findByIdAndDeletedIsFalse(long id);
    boolean existsByEmail(String email);
}
