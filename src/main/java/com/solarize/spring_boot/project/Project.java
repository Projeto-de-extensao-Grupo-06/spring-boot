package com.solarize.spring_boot.project;

import com.solarize.spring_boot.technical.Technical;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Double totalValue;
    private List<String> itensToInstall; // TODO implementar classe Item
    private String status;

    private String engineer; // TODO implementar classe Engineer
    private String client; // TODO implementar classe Client

    private List<String> coworkers; // TODO implementar classe Coworker
    private List<String> address; // TODO implementar classe Address
    private List<String> budget; // TODO implementar classe Budget
    private List<String> schedules; // TODO implementar classe Schedule

    @ManyToOne
    @JoinColumn(name = "technical_id")
    private Technical technical;

    public Integer getId() {
        return id;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<String> getCoworkers() {
        return coworkers;
    }

    public void setCoworkers(List<String> coworkers) {
        this.coworkers = coworkers;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public List<String> getBudget() {
        return budget;
    }

    public void setBudget(List<String> budget) {
        this.budget = budget;
    }

    public List<String> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<String> schedules) {
        this.schedules = schedules;
    }

    public List<String> getItensToInstall() {
        return itensToInstall;
    }

    public void setItensToInstall(List<String> itensToInstall) {
        this.itensToInstall = itensToInstall;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Technical getTechnical() {
        return technical;
    }

    public void setTechnical(Technical technical) {
        this.technical = technical;
    }


}
