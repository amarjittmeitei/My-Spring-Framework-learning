package com.yawolart.crudDtoDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	Here, we are making the code look more professional
		1. DTO is added for better privacy and control
		2. Custom exception handling instead of let the spring boot do it with its
			generic exception handling methods
 */

@SpringBootApplication
public class CrudDtoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDtoDemoApplication.class, args);
		System.out.println("Amarjit: My crudDtoDemo server started");
	}

}
