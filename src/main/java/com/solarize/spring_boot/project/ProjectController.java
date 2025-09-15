package com.solarize.spring_boot.project;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService SERVICE;

    public ProjectController(ProjectService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @PostMapping
    public ResponseEntity<Project> postProject
            (@Valid @RequestBody Project project){
        return ResponseEntity
                .status(201).body(SERVICE.postProject(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Integer id){
        return ResponseEntity.status(200).body(SERVICE.getProject(id));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
       if(SERVICE.getProjects().isEmpty()) {
           return ResponseEntity.status(204).build();
       }
       return ResponseEntity.status(200).body(SERVICE.getProjects());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> putProject(@PathVariable Integer id, @RequestBody Project project){
        return ResponseEntity.status(201).body(SERVICE.putProject(id,project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id){
        SERVICE.deleteProject(id);
        return ResponseEntity.status(204).build();
    }

//    @GetMapping("/byTechinical")
//    public ResponseEntity<List<Project>> getProjectsByTechnical(@RequestParam Integer id){
//        if(SERVICE.getProjectsByTechnical(id).isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(200).body(SERVICE.getProjectsByTechnical(id));
//    }
}
