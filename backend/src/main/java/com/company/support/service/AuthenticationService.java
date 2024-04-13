package com.company.support.service;

import com.company.support.dto.authentication.SignInRequestDto;
import com.company.support.dto.authentication.SignUpRequestDto;
import com.company.support.dto.authentication.AuthenticationResponseDto;

public interface AuthenticationService {

    AuthenticationResponseDto signUp(SignUpRequestDto request);

    AuthenticationResponseDto signIn(SignInRequestDto request);
}
