package com.jns.personalmanagementapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record RecurrenceResponseDTO(
        UUID id,
        Byte dayOfMonth,
        Byte daysOfWeek,
        Byte weeksOfMonth,
        Short monthsOfYear,
        LocalDateTime deletedAt
) {}
