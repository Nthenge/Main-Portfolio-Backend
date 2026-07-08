package com.my.portfolio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
public class EmailSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String budget;
    private String service;

    @Column(length = 3000)
    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();

    public EmailSubmission() {}

    public EmailSubmission(String name, String email, String budget, String service, String description) {
        this.name = name;
        this.email = email;
        this.budget = budget;
        this.service = service;
        this.description = description;
    }

    // Getters (Jackson needs these to serialize the entity to JSON)
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getBudget() { return budget; }
    public String getService() { return service; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
