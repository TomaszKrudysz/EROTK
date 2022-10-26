package com.example.erptk.rest;
@FunctionalInterface
/**
 * Created by tkrud on 26.10.2022.
 */
public interface AuthenticationResultHandler {

    void handle(boolean authenticationResult);
}
