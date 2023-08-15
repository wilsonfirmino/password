package com.valid.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Valid Password API Documentation",
        version = "1.0.0",
        description = "API for password validation"
    )
)
public class PassWordApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassWordApiApplication.class, args);
    }
}


/*
@SpringBootApplication // é uma anotação que combina várias outras anotações do Spring;
//@EnableSwagger2
@EnableOpenApi
public class PassWordApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassWordApiApplication.class, args);
        
        System.out.println("teste - PassWordApiApplication");
        
    }
    */
