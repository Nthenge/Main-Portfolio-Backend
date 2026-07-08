package com.my.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    private Long id;

    private boolean available;

    public Availability() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}