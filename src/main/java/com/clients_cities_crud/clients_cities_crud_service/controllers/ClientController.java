package com.clients_cities_crud.clients_cities_crud_service.controllers;

import com.clients_cities_crud.clients_cities_crud_service.domains.Client;
import com.clients_cities_crud.clients_cities_crud_service.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService service;

    @PostMapping("/clients")
    public ResponseEntity<Void> insert(@RequestBody Client newClient) {
        Client clientObj = service.insert(newClient);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientObj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clientList = service.findAll();

        return ResponseEntity.ok().body(clientList);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> findById(@PathVariable String id) {
        Client clientObj = service.findById(id);

        return ResponseEntity.ok().body(clientObj);
    }

    @GetMapping("/clients/name/{name}")
    public ResponseEntity<List<Client>> findByName(@PathVariable String name) {
        List<Client> clientListObj = service.findByName(name);

        return ResponseEntity.ok().body(clientListObj);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Void> updateName(
            @RequestBody Client clientNewNameObj,
            @PathVariable String id
    ) {
        clientNewNameObj.setId(id);
        service.updateName(clientNewNameObj);

        return ResponseEntity.noContent().build();
    }
}
