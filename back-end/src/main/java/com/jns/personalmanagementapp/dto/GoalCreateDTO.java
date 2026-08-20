package com.jns.personalmanagementapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record GoalCreateDTO(
   @NotBlank String name,
   String description,
   LocalDate toFinishAt,
   @NotNull UUID userId
) {}