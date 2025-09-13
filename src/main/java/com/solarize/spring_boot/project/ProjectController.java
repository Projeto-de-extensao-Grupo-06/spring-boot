package com.solarize.spring_boot.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectRepository REPOSITORY;

    public ProjectController(ProjectRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @PostMapping
    public ResponseEntity<Project> postProject(@RequestBody Project project){
        return ResponseEntity
                .status(201)
                .body(REPOSITORY.save(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Integer id){
        Optional<Project> project = REPOSITORY.findById(id);

        if( project.isEmpty() ) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity
                .status(200)
                .body(project.get());
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        List<Project> projects = REPOSITORY.findAll();

        if( projects.isEmpty() ){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity
                .status(200)
                .body(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> putProject(@PathVariable Integer id, @RequestBody Project project){
        if( REPOSITORY.findById(id).isEmpty() ){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body( REPOSITORY.save(project) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id){
        if( REPOSITORY.findById(id).isEmpty() ){
            return ResponseEntity.status(404).build();
        }

        REPOSITORY.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/byTechinical")
    public ResponseEntity<List<Project>> getProjectsByTechnical(@RequestParam Integer id){
        List<Project> projects = REPOSITORY.findByTechnicalId(id);

        if( projects.isEmpty() ) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity
                .status(200)
                .body(projects);
    }
}
