package com.jns.personalmanagementapp.dto;

import java.time.LocalDate;

public record GoalUpdateDTO(
    String name,
    String description,
    LocalDate toFinishAt
) {}