package com.solarize.spring_boot.technical;

import com.solarize.spring_boot.technical.Technical;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/technicals")
public class TechnicalController {

    private final TechnicalService SERVICE;

    public TechnicalController(TechnicalService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @PostMapping
    public ResponseEntity<Technical> postTechnical(@Valid @RequestBody Technical technical){
       return ResponseEntity
               .status(201).body(SERVICE.postTechnical(technical));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technical> getTechnical(@PathVariable Integer id){
        return ResponseEntity.status(200).body(SERVICE.getTechnical(id));
    }

    @GetMapping
    public ResponseEntity<List<Technical>> getTechnicals(){
        if(SERVICE.getTechnicals().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(SERVICE.getTechnicals());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technical> putTechnical(@PathVariable Integer id, @RequestBody Technical technical){
        return ResponseEntity.status(201).body(SERVICE.putTechnical(id,technical));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnical(@PathVariable Integer id){
        SERVICE.deleteTechnical(id);
        return ResponseEntity.status(204).build();
    }

//    @GetMapping("/byName")
//    public ResponseEntity<List<Technical>> getTechnicalsByName(@RequestParam String name){
//        if(SERVICE.getTechnicalsByName(name).isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(200).body(SERVICE.getTechnicalsByName(name));
//    }
}
