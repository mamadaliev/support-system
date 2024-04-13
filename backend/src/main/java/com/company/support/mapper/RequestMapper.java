package com.company.support.mapper;

import com.company.support.dto.request.RequestCreateDto;
import com.company.support.dto.request.RequestResponseDto;
import com.company.support.dto.request.RequestUpdateDto;
import com.company.support.entity.request.RequestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author.id", source = "createDto.authorId")
    @Mapping(target = "assigner.id", source = "createDto.assignerId")
    RequestEntity createDtoToEntity(RequestCreateDto createDto);

    @Mapping(target = "author.id", source = "updateDto.authorId")
    @Mapping(target = "assigner.id", source = "updateDto.assignerId")
    RequestEntity updateDtoToEntity(RequestUpdateDto updateDto);

    @Mapping(target = "authorId", source = "entity.author.id")
    @Mapping(target = "assignerId", source = "entity.assigner.id")
    RequestResponseDto entityToResponseDto(RequestEntity entity);
}
