package com.jns.personalmanagementapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record RoutineCreateDTO(
        @NotBlank String name,
        String description,
        LocalDateTime startAt,
        @NotNull RecurrenceCreateDTO recurrenceCreateDTO,
        @NotNull UUID userId,
        GoalCreateDTO goalCreateDTO
)
{}