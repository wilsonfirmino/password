package com.valid.password.api.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Requisição de validação de senha")
public class PasswordRequest {
    @Schema(description = "Senha a ser validada", example = "StarTeste@2011")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
