package com.valid.password.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.valid.password.api.model.PasswordRequest;

public class PasswordValidationControllerTest {	

    private PasswordValidationController controller;

    @BeforeEach
    public void setUp() {
        controller = new PasswordValidationController();
    }

    @Test
    public void testValidPassword1() {
        PasswordRequest request = new PasswordRequest();
        request.setPassword("Valid@Pass123");
        
        ResponseEntity<String> response = controller.validatePassword(request);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Senha válida!", response.getBody());
    }
    
    @Test
    public void testValidPassword2() {
        PasswordRequest request = new PasswordRequest();
        request.setPassword("Star@Pass2013");
        
        ResponseEntity<String> response = controller.validatePassword(request);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Senha válida!", response.getBody());
    }

    @Test
    public void testInvalidPassword1() {
        PasswordRequest request = new PasswordRequest();
        request.setPassword("invalid");

        ResponseEntity<String> response = controller.validatePassword(request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Senha inválida! A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.", response.getBody());
    }
    
    @Test
    public void testInvalidPassword2() {
        PasswordRequest request = new PasswordRequest();
        request.setPassword("12345678");

        ResponseEntity<String> response = controller.validatePassword(request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Senha inválida! A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.", response.getBody());
    }

}
