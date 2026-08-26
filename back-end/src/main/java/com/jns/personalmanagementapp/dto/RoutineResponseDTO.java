package com.jns.personalmanagementapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record RoutineResponseDTO(
        UUID id,
        String name,
        String description,
        LocalDateTime createdAt,
        LocalDateTime startAt,
        LocalDateTime deletedAt,
        UUID recurrenceId,
        UUID userId,
        UUID goalId,
        Byte statusOfRoutinesId
) {}