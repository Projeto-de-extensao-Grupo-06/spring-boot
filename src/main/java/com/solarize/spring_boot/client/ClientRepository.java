package com.solarize.spring_boot.client;

import com.solarize.spring_boot.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
