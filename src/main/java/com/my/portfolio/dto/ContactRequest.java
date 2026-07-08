package com.my.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        String budget,

        String service,

        @NotBlank(message = "Project description is required")
        @Size(max = 6000, message = "Description is too long")
        String description
) {}
