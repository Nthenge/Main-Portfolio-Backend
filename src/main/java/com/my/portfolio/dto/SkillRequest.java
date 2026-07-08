package com.my.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

public record SkillRequest(@NotBlank String name, Integer sortOrder) {}
