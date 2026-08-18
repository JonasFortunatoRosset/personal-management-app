package com.jns.personalmanagementapp.dto;

import com.jns.personalmanagementapp.enums.WeekOfMonth;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.List;

public record RecurrenceCreateDTO(
        Byte dayOfMonth,
        List<DayOfWeek> daysOfWeek,
        List<WeekOfMonth> weeksOfMonth,
        List<Month> monthsOfYear
) {}