package com.solarize.spring_boot.project;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository REPOSITORY;

    public ProjectService(ProjectRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    public Project postProject(Project project) {
        return REPOSITORY.save(project);
    }

    public Project getProject(Integer id) {
       return REPOSITORY.findById(id).orElseThrow(
               () -> new EntityNotFoundException("")
       );
    }

    public List<Project> getProjects() {
        return REPOSITORY.findAll();
    }

    public Project putProject(Integer id, Project project) {
        if(REPOSITORY.findById(id).isEmpty()) {
            throw new EntityNotFoundException("");
        }
        return REPOSITORY.save(project);
    }

    public void deleteProject(Integer id) {
        if(REPOSITORY.findById(id).isEmpty()) {
            throw new EntityNotFoundException("");
        }
        REPOSITORY.deleteById(id);
    }

//    public List<Project> getProjectsByTechnical(Integer id) {
//        if(REPOSITORY.findByTechnicalId(id).isEmpty()) {
//            throw new EntityNotFoundException("");
//        }
//        return REPOSITORY.findByTechnicalId(id);
//    }

}
