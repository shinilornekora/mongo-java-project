package org.shiniasse.services.impl;

import org.shiniasse.models.Project;
import org.shiniasse.repositories.ProjectRepository;
import org.shiniasse.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    public ProjectRepository projectRepository;

    @Override
    public Project getProjectByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProjectByName(String name) {
        projectRepository.deleteByName(name);
    }

    @Override
    public void saveAllProjects(List<Project> projects) {
        projectRepository.saveAll(projects);
    }

    @Override
    public List<Project> aggregateProjectsBySum() {
        return projectRepository.aggregateProjectsBySum();
    }
    @Override
    public void deleteAll() {
        projectRepository.deleteAll();
    }
}
