package com.jns.personalmanagementapp.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UserCreateDTO(
        @NotBlank String name,
        String lastName,
        @NotBlank @Email String email,
        @NotBlank String password,
        LocalDate birthDate
) {}