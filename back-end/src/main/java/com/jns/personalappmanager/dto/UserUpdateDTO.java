package com.jns.personalappmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserUpdateDTO(
        String name,
        String lastName,
        @NotBlank @Email String email,
        String newEmail,
        String password,
        LocalDate birthDate,
        Boolean isActive,
        LocalDateTime deletedAt
)
{}
