package com.valid.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // é uma anotação que combina várias outras anotações do Spring;
//@EnableSwagger2
public class PassWordApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassWordApiApplication.class, args);
        
        System.out.println("teste - PassWordApiApplication");
        
    }
}