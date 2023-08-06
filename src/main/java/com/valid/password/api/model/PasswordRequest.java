package com.valid.password.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Requisição de validação de senha")
public class PasswordRequest {
    @ApiModelProperty(value = "Senha a ser validada", example = "Star@2011")
    private String password;

    // getters e setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}