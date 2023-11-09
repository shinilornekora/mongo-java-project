package org.shiniasse.services;

import org.shiniasse.models.Project;
import org.shiniasse.models.Task;

import java.util.List;

public interface ProjectService {
    Project getProjectByName(String name);
    List<Project> getAll();
    void saveProject(Project project);

    void updateProject(Project project);

    void deleteProjectByName(String name);

    void saveAllProjects(List<Project> projects);
    void deleteAll();
    List<Project> aggregateProjectsBySum();

}
