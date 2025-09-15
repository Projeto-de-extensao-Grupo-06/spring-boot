package com.solarize.spring_boot.client;

import com.solarize.spring_boot.project.Project;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService SERVICE;

    public ClientController(ClientService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @PostMapping
    public ResponseEntity<Client> postClient(
            @Valid @RequestBody Client client
    ) {
        return ResponseEntity.status(201)
                .body(SERVICE.postClient(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(
            @PathVariable Integer id
    ) {
        return ResponseEntity.status(200).body(SERVICE.getClient(id));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        if(SERVICE.getClients().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(SERVICE.getClients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> putClient(@PathVariable Integer id, @RequestBody Client client){
        return ResponseEntity.status(201).body(SERVICE.putClient(id,client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id){
        SERVICE.deleteClient(id);
        return ResponseEntity.status(204).build();
    }
}
