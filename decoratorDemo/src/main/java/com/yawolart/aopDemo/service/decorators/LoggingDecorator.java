package com.yawolart.aopDemo.service.decorators;

import com.yawolart.aopDemo.service.StudentService;
import com.yawolart.aopDemo.service.StudentServiceImpl;
import com.yawolart.aopDemo.service.helper.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService {

    StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent() {
        Logger.startLog(
                studentServiceImpl.getClass().getName(),
                "createStudent");

        studentServiceImpl.createStudent();

        Logger.endLog(
                studentServiceImpl.getClass().getName(),
                "createStudent"
        );
    }
}
