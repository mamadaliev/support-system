package com.company.support.service;

import com.company.support.entity.user.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDetailsService userDetailsService();

    UserEntity getById(UUID userId);

    UserEntity getByUsername(String username);

    List<UserEntity> getAll();
}
