package com.jns.personalmanagementapp.dto;

import com.jns.personalmanagementapp.enums.WeekOfMonth;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.List;
import java.util.UUID;

public record RecurrenceUpdateDTO(
        Byte dayOfMonth,
        List<DayOfWeek> daysOfWeek,
        List<WeekOfMonth> weeksOfMonth,
        List<Month> monthsOfYear
) {}