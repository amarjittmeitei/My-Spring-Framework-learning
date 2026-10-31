package com.yawolart.interceptorDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterceptorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterceptorDemoApplication.class, args);
		System.out.println("Amarjit: My server started");
	}

}
