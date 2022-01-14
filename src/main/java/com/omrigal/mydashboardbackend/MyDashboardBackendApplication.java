package com.omrigal.mydashboardbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class MyDashboardBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDashboardBackendApplication.class, args);
    }

}
