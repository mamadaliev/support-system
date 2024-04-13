package com.company.support.service.impl;

import com.company.support.entity.user.UserEntity;
import com.company.support.repository.UserRepository;
import com.company.support.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public UserEntity getById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(String.format("No user found by identifier '%s'", userId)));
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(String.format("No user found by username '%s'", username)));
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
