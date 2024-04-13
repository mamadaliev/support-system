package com.company.support.mapper;

import com.company.support.dto.UserResponseDto;
import com.company.support.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "lastName", source = "user.lastName")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "role", source = "user.role")
    UserResponseDto entityToDto(UserEntity user);
}
