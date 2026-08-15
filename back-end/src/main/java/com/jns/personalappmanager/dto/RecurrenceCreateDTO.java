package com.jns.personalappmanager.dto;

public record RecurrenceCreateDTO(
        Byte dayOfMonth,
        Byte daysOfWeek,
        Byte weeksOfMonth,
        Byte monthsOfYear
) {}