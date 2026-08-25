package com.jns.personalmanagementapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TaskCreateDTO(
        @NotBlank String name,
        String description,
        @NotNull boolean allowsMultipleCompletions,
        @NotNull UUID userId,
        UUID goalId,
        UUID routineId
) {}