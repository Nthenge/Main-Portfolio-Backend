package com.my.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank String name,
        @NotBlank String domain,
        @NotBlank String description,
        String link,
        Integer sortOrder,
        String techStack,
        String highlight,
        String siteUrl
) {}
