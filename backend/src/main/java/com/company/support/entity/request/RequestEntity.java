package com.company.support.entity.request;

import com.company.support.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "requests")
public class RequestEntity {

    @Id
    private UUID id;

    private String name;

    private String description;

    private RequestPriority priority;

    @OneToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @OneToOne
    @JoinColumn(name = "assigner_id")
    private UserEntity assigner;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
