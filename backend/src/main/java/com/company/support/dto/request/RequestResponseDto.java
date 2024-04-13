package com.company.support.dto.request;

import com.company.support.entity.request.RequestPriority;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class RequestResponseDto {

    private UUID id;

    private String name;

    private String description;

    private RequestPriority priority;

    private UUID authorId;

    private UUID assignerId;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
