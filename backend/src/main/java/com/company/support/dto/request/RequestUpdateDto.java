package com.company.support.dto.request;

import com.company.support.entity.request.RequestPriority;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class RequestUpdateDto {

    private UUID id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private String description;

    @NotNull(message = "Priority cannot be null")
    private RequestPriority priority;

    private UUID authorId;

    private UUID assignerId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dueDate;
}
