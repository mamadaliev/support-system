package com.company.support.dto;

import com.company.support.entity.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String username;

    private UserRole role;
}
