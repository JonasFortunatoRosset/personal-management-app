package com.jns.personalmanagementapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
        @NotNull UUID id,
        @NotBlank String name,
        String lastName,
        @NotBlank @Email String email,
        LocalDate birthDate,
        LocalDateTime createdAt,
        boolean isActive,
        LocalDateTime deletedAt
){}