package com.yawolart.profilingDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfilingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilingDemoApplication.class, args);
		System.out.println("Amarjit: my server started");
	}

}
