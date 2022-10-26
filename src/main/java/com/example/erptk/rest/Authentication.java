package com.example.erptk.rest;

import com.example.erptk.dto.UserCredentialsDto;

/**
 * Created by tkrud on 26.10.2022.
 */
public interface Authentication {
    void authenticate(UserCredentialsDto userCredentialsDto,AuthenticationResultHandler authenticationResultHandler);
}
