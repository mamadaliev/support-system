package com.company.support.service.impl;

import com.company.support.entity.user.UserEntity;
import com.company.support.repository.UserRepository;
import com.company.support.dto.authentication.SignInRequestDto;
import com.company.support.dto.authentication.SignUpRequestDto;
import com.company.support.dto.authentication.AuthenticationResponseDto;
import com.company.support.entity.user.UserRole;
import com.company.support.service.AuthenticationService;
import com.company.support.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Transactional
    @Override
    public AuthenticationResponseDto signUp(SignUpRequestDto request) {
        var user = UserEntity.builder()
                .id(UUID.randomUUID())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername()).password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER).build();

        userRepository.save(user);
        log.info("New user '{}' has been signed up", user.getUsername());

        var jwt = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder().token(jwt).build();
    }

    @Override
    public AuthenticationResponseDto signIn(SignInRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));

        log.info("User '{}' has been successfully signed in", user.getUsername());
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder().token(jwt).build();
    }
}
