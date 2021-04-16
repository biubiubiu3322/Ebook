package com.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication()
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringbootEbookangular1001Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootEbookangular1001Application.class, args);
    }

}
