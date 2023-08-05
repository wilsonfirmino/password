package com.valid.password.api.model;

//@ApiModel(description = "Requisição de validação de senha")
public class PasswordRequest {
    //@ApiModelProperty(value = "Senha a ser validada", example = "Star@2011")
    private String password;

    // getters e setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}