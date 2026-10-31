package com.yawolart.aopDemo.service.decorators;

import com.yawolart.aopDemo.service.StudentService;
import com.yawolart.aopDemo.service.helper.TimeCounter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeDecorator implements StudentService {

    LoggingDecorator prevDeco;

    public ExecutionTimeDecorator(LoggingDecorator prevDeco) {
        this.prevDeco = prevDeco;
    }

    @Override
    public void createStudent() {
        TimeCounter.startCounting();
        prevDeco.createStudent();
        TimeCounter.stopCounting();
    }
}
