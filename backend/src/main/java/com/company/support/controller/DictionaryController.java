package com.company.support.controller;

import com.company.support.entity.request.RequestPriority;
import com.company.support.entity.request.RequestStatus;
import com.company.support.entity.user.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary")
public class DictionaryController {

    @GetMapping("/priorities")
    public List<String> getRequestPriorities() {
        return Arrays.stream(RequestPriority.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @GetMapping("/statuses")
    public List<String> getRequestStatuses() {
        return Arrays.stream(RequestStatus.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @GetMapping("/roles")
    public List<String> getUserRoles() {
        return Arrays.stream(UserRole.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
