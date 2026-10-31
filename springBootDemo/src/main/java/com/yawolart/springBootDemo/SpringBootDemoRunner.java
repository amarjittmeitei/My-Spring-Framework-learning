package com.yawolart.springBootDemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
//public class SpringBootDemoRunner implements CommandLineRunner{
public class SpringBootDemoRunner implements ApplicationRunner {
    private PaymentGateway paymentGateway;

    public SpringBootDemoRunner(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        paymentGateway.printProperties();
    }


    /*for CommandLineRunner interface*/
//    @Override
//    public void run(String... args) throws Exception {
//        paymentGateway.printProperties();
//    }
}
