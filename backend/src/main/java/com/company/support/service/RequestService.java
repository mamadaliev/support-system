package com.company.support.service;

import com.company.support.entity.request.RequestEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RequestService {

    List<RequestEntity> getAllRequests();

    Optional<RequestEntity> getRequestById(UUID id);

    RequestEntity createRequest(RequestEntity request);

    RequestEntity updateRequest(UUID id, RequestEntity request);

    void deleteRequest(UUID id);
}
