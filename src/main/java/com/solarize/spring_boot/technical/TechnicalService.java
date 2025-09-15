package com.solarize.spring_boot.technical;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalService {

    private final TechnicalRepository REPOSITORY;

    public TechnicalService(TechnicalRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    public Technical postTechnical(Technical technical) {
        return REPOSITORY.save(technical);
    }

    public Technical getTechnical(Integer id) {
        return REPOSITORY.findById(id).orElseThrow(
                () -> new EntityNotFoundException("")
        );
    }

    public List<Technical> getTechnicals() {
     return REPOSITORY.findAll();
    }

    public Technical putTechnical(Integer id, Technical technical) {
        if(REPOSITORY.findById(id).isEmpty()) {
            throw new EntityNotFoundException("");
        }
        return REPOSITORY.save(technical);
    }

    public void deleteTechnical(Integer id) {
        if(REPOSITORY.findById(id).isEmpty()) {
            throw new EntityNotFoundException("");
        }
        REPOSITORY.deleteById(id);
    }

//    public List<Technical> getTechnicalsByName(String name) {
//        if(REPOSITORY.findByNameContainingIgnoreCase(name).isEmpty()) {
//            throw new EntityNotFoundException("");
//        }
//        return REPOSITORY.findByNameContainingIgnoreCase(name);
//    }

}
