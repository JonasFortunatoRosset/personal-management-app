package com.jns.personalmanagementapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskUpdateDTO(
        String name,
        String description,
        UUID goalId,
        UUID routineId
) {}