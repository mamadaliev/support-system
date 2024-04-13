package com.company.support.controller;

import com.company.support.dto.request.RequestCreateDto;
import com.company.support.dto.request.RequestResponseDto;
import com.company.support.dto.request.RequestUpdateDto;
import com.company.support.entity.request.RequestEntity;
import com.company.support.mapper.RequestMapper;
import com.company.support.service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    private final RequestMapper requestMapper;

    @GetMapping
    public ResponseEntity<List<RequestResponseDto>> getAllRequests() {
        List<RequestEntity> requests = requestService.getAllRequests();
        List<RequestResponseDto> dtos = requests.stream()
                .map(requestMapper::entityToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestResponseDto> getRequestById(@PathVariable UUID id) {
        return requestService.getRequestById(id)
                .map(requestMapper::entityToResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RequestResponseDto> createRequest(@Valid @RequestBody RequestCreateDto createDto) {
        RequestEntity requestEntity = requestMapper.createDtoToEntity(createDto);
        RequestEntity createdRequest = requestService.createRequest(requestEntity);
        RequestResponseDto responseDto = requestMapper.entityToResponseDto(createdRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestResponseDto> updateRequest(@PathVariable UUID id, @Valid @RequestBody RequestUpdateDto updateDto) {
        RequestEntity existingRequest = requestService.getRequestById(id)
                .orElseThrow(() -> new IllegalArgumentException("Request with id " + id + " not found"));
        RequestEntity updatedEntity = requestMapper.updateDtoToEntity(updateDto);
        updatedEntity.setId(existingRequest.getId());
        RequestEntity updatedRequest = requestService.updateRequest(id, updatedEntity);
        RequestResponseDto responseDto = requestMapper.entityToResponseDto(updatedRequest);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable UUID id) {
        requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
