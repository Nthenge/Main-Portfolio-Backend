package com.my.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    private Long id;

    private boolean available;

    private Long yop;

    private Long productionApis;

    public Availability() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public Long getYop() {
        return yop;
    }

    public void setYop(Long yop) {
        this.yop = yop;
    }

    public Long getProductionApis() {
        return productionApis;
    }

    public void setProductionApis(Long productionApis) {
        this.productionApis = productionApis;
    }
}