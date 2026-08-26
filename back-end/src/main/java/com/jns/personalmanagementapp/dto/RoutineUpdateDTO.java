package com.jns.personalmanagementapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record RoutineUpdateDTO(
        String name,
        String description,
        LocalDateTime startAt,
        UUID recurrenceId,
        UUID goalId,
        Byte statusOfRoutinesId
) {}