package com.solarize.spring_boot.technical;

import com.solarize.spring_boot.technical.Technical;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/technicals")
public class TechnicalController {
    private final TechnicalRepository REPOSITORY;

    public TechnicalController(TechnicalRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @PostMapping
    public ResponseEntity<Technical> postTechnical(@RequestBody Technical technical){
        return ResponseEntity
                .status(201)
                .body(REPOSITORY.save(technical));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technical> getTechnical(@PathVariable Integer id){
        Optional<Technical> technical = REPOSITORY.findById(id);

        if( technical.isEmpty() ) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity
                .status(200)
                .body(technical.get());
    }

    @GetMapping
    public ResponseEntity<List<Technical>> getTechnicals(){
        List<Technical> technicals = REPOSITORY.findAll();

        if( technicals.isEmpty() ){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity
                .status(200)
                .body(technicals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technical> putTechnical(@PathVariable Integer id, @RequestBody Technical technical){
        if( REPOSITORY.findById(id).isEmpty() ){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body( REPOSITORY.save(technical) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnical(@PathVariable Integer id){
        if( REPOSITORY.findById(id).isEmpty() ){
            return ResponseEntity.status(404).build();
        }

        REPOSITORY.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/byName")
    public ResponseEntity<List<Technical>> getTechnicalsByName(@RequestParam String name){
        List<Technical> technicals = REPOSITORY.findByNameContainingIgnoreCase(name);

        if( technicals.isEmpty() ) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity
                .status(200)
                .body(technicals);
    }
}
