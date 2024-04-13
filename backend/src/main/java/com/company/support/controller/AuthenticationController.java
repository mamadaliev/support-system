package com.company.support.controller;

import com.company.support.dto.authentication.SignInRequestDto;
import com.company.support.dto.authentication.SignUpRequestDto;
import com.company.support.dto.authentication.AuthenticationResponseDto;
import com.company.support.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthenticationResponseDto> signUp(@RequestBody SignUpRequestDto request) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponseDto> signIn(@RequestBody SignInRequestDto request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
