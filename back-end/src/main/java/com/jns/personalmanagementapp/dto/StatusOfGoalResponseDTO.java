package com.jns.personalmanagementapp.dto;

import java.util.UUID;

public record StatusOfGoalResponseDTO(
        UUID id,
        String name
) {}