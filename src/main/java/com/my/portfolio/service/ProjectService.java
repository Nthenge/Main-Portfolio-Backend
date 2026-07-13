package com.my.portfolio.service;

import com.my.portfolio.dto.ProjectRequest;
import com.my.portfolio.model.Project;
import com.my.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAllByOrderBySortOrderAsc();
    }

    public Project createProject(ProjectRequest request) {
        Project project = new Project();
        project.setName(request.name());
        project.setDomain(request.domain());
        project.setDescription(request.description());
        project.setLink(request.link());
        project.setSortOrder(request.sortOrder());
        project.setTechStack(request.techStack());
        project.setHighlight(request.highlight());
        project.setSiteUrl(request.siteUrl());
        project.setStatus(true);
        return projectRepository.save(project);
    }
}
