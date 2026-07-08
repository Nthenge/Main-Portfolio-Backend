package com.my.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String title;
    private String subtitle;
    private boolean wide;
    private Integer sortOrder;

    public ServiceOffering() {}

    public Long getId() { return id; }
    public String getNumber() { return number; }
    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public boolean isWide() { return wide; }
    public Integer getSortOrder() { return sortOrder; }

    public void setNumber(String number) { this.number = number; }
    public void setTitle(String title) { this.title = title; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public void setWide(boolean wide) { this.wide = wide; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
}
