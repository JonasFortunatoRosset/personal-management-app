package com.jns.personalmanagementapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponseDTO(
        UUID id,
        String name,
        String description,
        boolean allowsMultipleCompletions,
        LocalDateTime createdAt,
        LocalDateTime deletedAt,
        UUID userId,
        UUID goalId,
        UUID routineId
) {}