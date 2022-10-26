package com.example.erptk.rest;

import com.example.erptk.dto.UserCredentialsDto;

/**
 * Created by tkrud on 26.10.2022.
 */
public class AuthenticationImpl implements Authentication{
    private static final String LOGIN = "skuser";
    private static final String PASSWORD = "skpassword";



    @Override
    public void authenticate(UserCredentialsDto userCredentialsDto, AuthenticationResultHandler authenticationResultHandler) {
        Runnable authenticationTask = createAuthenticationTask(userCredentialsDto, authenticationResultHandler);
        Thread authenticationThread = new Thread(authenticationTask);
        authenticationThread.setDaemon(true);
        authenticationThread.start();
    }

    private Runnable createAuthenticationTask(UserCredentialsDto userCredentialsDto,
                                       AuthenticationResultHandler authenticationResultHandler) {
        return () ->{
            try {
                Thread.sleep(3000);
                boolean authenticated =
                        LOGIN.equals(userCredentialsDto.getLogin()) && PASSWORD.equals(userCredentialsDto.getPassword());
                System.out.println("is user authenticated? " + authenticated);
                authenticationResultHandler.handle(authenticated);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
