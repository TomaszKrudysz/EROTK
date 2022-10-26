package com.example.erptk.dto;

/**
 * Created by tkrud on 26.10.2022.
 */
public class UserCredentialsDto {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
