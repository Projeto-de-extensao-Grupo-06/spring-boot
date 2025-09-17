package com.solarize.spring_boot.project;

import com.solarize.spring_boot.client.Client;
import com.solarize.spring_boot.technical.Technical;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Positive
    private Double totalValue;
    private List<String> itensToInstall; // TODO implementar classe Item
    private String status;

    private String engineer; // TODO implementar classe Engineer

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private List<String> coworkers; // TODO implementar classe Coworker
    private String address; // TODO implementar classe Address
    private List<String> budget; // TODO implementar classe Budget
    private List<String> schedules; // TODO implementar classe Schedule

    @ManyToOne
    @JoinColumn(name = "technical_id")
    private Technical technical;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getBudget() {
        return budget;
    }

    public void setBudget(List<String> budget) {
        this.budget = budget;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<String> getCoworkers() {
        return coworkers;
    }

    public void setCoworkers(List<String> coworkers) {
        this.coworkers = coworkers;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getItensToInstall() {
        return itensToInstall;
    }

    public void setItensToInstall(List<String> itensToInstall) {
        this.itensToInstall = itensToInstall;
    }

    public List<String> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<String> schedules) {
        this.schedules = schedules;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Technical getTechnical() {
        return technical;
    }

    public void setTechnical(Technical technical) {
        this.technical = technical;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
