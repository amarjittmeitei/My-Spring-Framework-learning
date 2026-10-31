package com.yawolart.springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args)
	{
//		ApplicationContext context =
//				SpringApplication.run(SpringBootDemoApplication.class, args);
//
//		/*
//		inject application data using @Value annotation
//		to run this remove all the @Component and @ConfigutationProperties
//		annotation from
//			PaymentGateway.java
//			PaymentProperties.java
//			SpringBootDemoRunner.java
//		*/
//		PaymentGatewayDemo paymentGatewayDemo =
//				context.getBean(PaymentGatewayDemo.class);
//		System.out.println("type: "+paymentGatewayDemo.getType());
//		System.out.println("retryCount: "+paymentGatewayDemo.getRetryCount());
//
//
//		/*Without using @Value annotation as it is error-prone*/
//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//		paymentGateway.printProperties();

		//run by using runner interface implementation - standard way to do
		SpringApplication.run(SpringBootDemoApplication.class,args);
	}

}
