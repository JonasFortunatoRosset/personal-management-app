package com.jns.personalmanagementapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskHistoryCreateDTO(
        LocalDate scheduledFor,
        LocalDateTime completedAt,
        UUID taskId
) {}