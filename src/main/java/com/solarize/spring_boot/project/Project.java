package com.solarize.spring_boot.project;

import com.solarize.spring_boot.technical.Technical;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double totalVale;
    private List<String> itensToInstall; // TODO implementar classe Item
    private String status;

    private String engineer; // TODO implementar classe Engineer
    private String client; // TODO implementar classe Client

    @ManyToOne
    @JoinColumn(name = "technical_id")
    private Technical technical;

    public Integer getId() {
        return id;
    }

    public Double getTotalVale() {
        return totalVale;
    }

    public void setTotalVale(Double totalVale) {
        this.totalVale = totalVale;
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
