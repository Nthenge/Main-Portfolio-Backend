package com.my.portfolio.controller;

import com.my.portfolio.dto.ProjectRequest;
import com.my.portfolio.model.Project;
import com.my.portfolio.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody ProjectRequest request) {
        return projectService.createProject(request);
    }
}
