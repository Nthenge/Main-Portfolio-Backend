package com.my.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String domain;

    @Column(length = 1000)
    private String description;

    private String link;
    private Integer sortOrder;
    private String siteUrl;

    private String techStack;   // comma-separated, e.g. "Java, Kafka, PostgreSQL"
    private String highlight;   // short metric, e.g. "40ms avg response · 99.9% uptime"

    private Boolean status;

    public Project() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDomain() { return domain; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
    public Integer getSortOrder() { return sortOrder; }
    public String getTechStack() { return techStack; }
    public String getHighlight() { return highlight; }

    public void setName(String name) { this.name = name; }
    public void setDomain(String domain) { this.domain = domain; }
    public void setDescription(String description) { this.description = description; }
    public void setLink(String link) { this.link = link; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    public void setTechStack(String techStack) { this.techStack = techStack; }
    public void setHighlight(String highlight) { this.highlight = highlight; }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
