package com.company.support.controller;

import com.company.support.dto.UserResponseDto;
import com.company.support.entity.user.UserEntity;
import com.company.support.mapper.UserMapper;
import com.company.support.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserResponseDto> getCurrentUser(@AuthenticationPrincipal UserDetails currentUser) {
        UserEntity user = userService.getByUsername(currentUser.getUsername());
        UserResponseDto dto = userMapper.entityToDto(user);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAll().stream()
                .map(userMapper::entityToDto)
                .toList();
    }
}
