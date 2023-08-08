package com.valid.password.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valid.password.api.model.PasswordRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Validação de Senha") 
public class PasswordValidationController {

    @PostMapping("/validate-password") 
	@ApiOperation(value = "Validar senha", notes = "Verifica se a senha atende aos critérios de validação.")
	@ApiResponses({
    	@ApiResponse(code = 200, message = "Senha válida"),
    	@ApiResponse(code = 400, message = "Senha inválida")
	}) 
    public ResponseEntity<String> validatePassword(@RequestBody PasswordRequest request) {
        String password = request.getPassword();

        if (isValidPassword(password)) {
        	return ResponseEntity.ok("Senha válida!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha inválida! A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.");
        }
    }

    private boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        /** Validações da senha:
        
     	(?=.*[a-z]): Verifica se há pelo menos uma letra minúscula na senha;
     	(?=.*[A-Z]): Verifica se há pelo menos uma letra maiúscula na senha;
     	(?=.*\\d): Verifica se há pelo menos um dígito numérico na senha;
     	(?=.*[@$!%*?&]): Verifica se há pelo menos um dos caracteres especiais [@, $, !, %, *, ?, &] na senha;
     	[A-Za-z\\d@$!%*?&]{8,}$: Verifica se a senha contém apenas letras maiúsculas, minúsculas; 
     							 dígitos numéricos ou os caracteres especiais mencionados; 
     							 e que a senha tenha pelo menos 8 caracteres no total;
     
         */

    }
}