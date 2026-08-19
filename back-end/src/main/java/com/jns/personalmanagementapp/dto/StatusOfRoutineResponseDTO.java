package com.jns.personalmanagementapp.dto;

import java.util.UUID;

public record StatusOfRoutineResponseDTO(
        UUID id,
        String name
) {}