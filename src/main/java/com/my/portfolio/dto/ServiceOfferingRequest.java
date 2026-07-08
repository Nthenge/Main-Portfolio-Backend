package com.my.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public record ServiceOfferingRequest(
        @NotBlank String number,
        @NotBlank String title,
        @NotBlank String subtitle,
        boolean wide,
        Integer sortOrder
) {}
