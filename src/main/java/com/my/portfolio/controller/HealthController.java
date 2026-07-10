package com.my.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private static final Instant START_TIME = Instant.now();

    @GetMapping
    public Map<String, Object> health() {
        long uptimeSeconds = Duration.between(START_TIME, Instant.now()).getSeconds();
        return Map.of(
                "status", "UP",
                "uptimeSeconds", uptimeSeconds,
                "timestamp", Instant.now().toString()
        );
    }

    @GetMapping("/up")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("UP");
    }
}
