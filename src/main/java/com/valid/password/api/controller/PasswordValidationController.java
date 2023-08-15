package com.valid.password.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valid.password.api.model.PasswordRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PasswordValidationController {

    @PostMapping("/validate-password")
    @Operation(summary = "Validar senha", description = "Verifica se a senha atende aos critérios de validação.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Senha válida"),
        @ApiResponse(responseCode = "400", description = "Senha inválida", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class), examples = @ExampleObject(value = "Senha inválida! A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.")))
    })
    public ResponseEntity<String> validatePassword(@RequestBody PasswordRequest request) {
        String password = request.getPassword();
        
        System.out.println(password);
        if (isValidPassword(password)) {
            return ResponseEntity.ok("Senha válida!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha inválida! A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.");
        }
    }

    private boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
}

/** Validações da senha:
    
     (?=.*[a-z]): Verifica se há pelo menos uma letra minúscula na senha;
     (?=.*[A-Z]): Verifica se há pelo menos uma letra maiúscula na senha;
     (?=.*\\d): Verifica se há pelo menos um dígito numérico na senha;
     (?=.*[@$!%*?&]): Verifica se há pelo menos um dos caracteres especiais [@, $, !, %, *, ?, &] na senha;
     [A-Za-z\\d@$!%*?&]{8,}$: Verifica se a senha contém apenas letras maiúsculas, minúsculas;
                              dígitos numéricos ou os caracteres especiais mencionados;
                              e que a senha tenha pelo menos 8 caracteres no total;
 
*/
