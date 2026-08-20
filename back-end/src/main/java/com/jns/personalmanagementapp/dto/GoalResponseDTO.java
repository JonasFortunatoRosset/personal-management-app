package com.jns.personalmanagementapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record GoalResponseDTO(
        UUID id,
        String name,
        String description,
        BigDecimal progress,
        LocalDateTime createdAt,
        LocalDate toFinishAt,
        LocalDate finishedAt,
        LocalDateTime deletedAt,
        Byte statusId,
        UUID userId
) {}