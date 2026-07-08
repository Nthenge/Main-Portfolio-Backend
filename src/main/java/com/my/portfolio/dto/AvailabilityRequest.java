package com.my.portfolio.dto;


import jakarta.validation.constraints.NotNull;

public record AvailabilityRequest(@NotNull Boolean available) {}
