package com.my.portfolio.controller;

import com.my.portfolio.dto.AvailabilityRequest;
import com.my.portfolio.service.AvailabilityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final AvailabilityService service;

    public AvailabilityController(AvailabilityService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Boolean> getAvailability() {
        return Map.of("available", service.isAvailable());
    }

    @PutMapping
    public Map<String, Boolean> updateAvailability(@Valid @RequestBody AvailabilityRequest request) {
        return Map.of("available", service.updateAvailability(request.available()));
    }

    @GetMapping("/yop")
    public Long getYop() {
        return service.getYop();
    }

    @GetMapping("/production-apis")
    public Long getProductionApis() {
        return service.getProductionApis();
    }
}
