package com.solarize.spring_boot.technical;

import com.solarize.spring_boot.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicalRepository extends JpaRepository<Technical, Integer> {
    List<Technical> findByNameContainingIgnoreCase(String name);
}
