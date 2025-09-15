package com.solarize.spring_boot.client;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository REPOSITORY;

    public ClientService(ClientRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    public Client postClient(Client client) {
        return REPOSITORY.save(client);
    }

    public Client getClient(Integer id) {
        return REPOSITORY.findById(id).orElseThrow(
                () -> new EntityNotFoundException("")
        );
    }

    public List<Client> getClients() {
        return REPOSITORY.findAll();
    }

    public Client putClient(Integer id, Client client) {
        if(REPOSITORY.findById(id).isEmpty()) {
            throw new EntityNotFoundException("");
        }
        return REPOSITORY.save(client);
    }

    public void deleteClient(Integer id) {
        if(REPOSITORY.findById(id).isEmpty()) {
            throw new EntityNotFoundException("");
        }
        REPOSITORY.deleteById(id);
    }
}
