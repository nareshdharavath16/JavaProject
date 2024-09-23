package com.qualifyde.kamai.userportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.qualifyde.kamai.userportal")
public class UserPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserPortalApplication.class, args);
    }
}
