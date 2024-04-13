package com.company.support.service.impl;

import com.company.support.entity.request.RequestEntity;
import com.company.support.repository.RequestRepository;
import com.company.support.service.RequestService;
import com.company.support.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final UserService userService;

    @Override
    public List<RequestEntity> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Optional<RequestEntity> getRequestById(UUID id) {
        return requestRepository.findById(id);
    }

    @Override
    public RequestEntity createRequest(RequestEntity request) {
        request.setId(UUID.randomUUID());
        request.setAuthor(userService.getById(request.getAuthor().getId()));
        request.setAssigner(userService.getById(request.getAssigner().getId()));
        request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());
        return requestRepository.save(request);
    }

    @Override
    public RequestEntity updateRequest(UUID id, RequestEntity requestEntity) {
        Optional<RequestEntity> existingRequestOptional = requestRepository.findById(id);
        if (existingRequestOptional.isPresent()) {
            RequestEntity existingRequest = existingRequestOptional.get();
            existingRequest.setName(requestEntity.getName());
            existingRequest.setDescription(requestEntity.getDescription());
            existingRequest.setPriority(requestEntity.getPriority());
            existingRequest.setAuthor(requestEntity.getAuthor());
            existingRequest.setAssigner(requestEntity.getAssigner());
            existingRequest.setDueDate(requestEntity.getDueDate());
            existingRequest.setUpdatedAt(LocalDateTime.now());
            return requestRepository.save(existingRequest);
        } else {
            throw new IllegalArgumentException("Request with id " + id + " not found");
        }
    }

    @Override
    public void deleteRequest(UUID id) {
        requestRepository.deleteById(id);
    }
}
