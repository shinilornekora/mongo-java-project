package org.shiniasse.init;

import org.shiniasse.models.Project;
import org.shiniasse.services.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private ProjectFactory projectFactory;
    @Autowired
    private TaskFactory taskFactory;
    @Autowired
    private DeveloperFactory developerFactory;
    @Autowired
    private ProjectServiceImpl projectService;
    @Override
    public void run(String... args) throws Exception {
        projectService.deleteAll();

        List<Project> projects = projectFactory.createProjects(10);
        projectService.saveAllProjects(projects);
    }
}
