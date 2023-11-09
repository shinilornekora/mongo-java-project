package org.shiniasse.controllers;

import org.shiniasse.models.Project;
import org.shiniasse.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    public ProjectService projectService;

    @GetMapping("/get/{name}")
    public Project getCountry(@PathVariable String name) {
        return projectService.getProjectByName(name);
    }
    @GetMapping("/getAll")
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @PostMapping("/add")
    public void addCountry(@RequestBody Project project) {
        projectService.saveProject(project);
    }

    @PostMapping("/update")
    public void updateCountry(@RequestBody Project project){
        projectService.saveProject(project);
    }

    @GetMapping("/delete/{name}")
    public void deleteCountry(@PathVariable String name){
        projectService.deleteProjectByName(name);
    }

    @GetMapping("/deleteAll")
    public void deleteAll(){
        projectService.deleteAll();
    }

    @GetMapping("/getAggregate")
    public List<Project> getAggregate(){
        return projectService.aggregateProjectsBySum();
    }
}
