package com.clients_cities_crud.clients_cities_crud_service.services;

import com.clients_cities_crud.clients_cities_crud_service.domains.Client;
import com.clients_cities_crud.clients_cities_crud_service.repositories.IClientRepository;
import com.clients_cities_crud.clients_cities_crud_service.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private IClientRepository repo;

    public Client insert(Client object) {
        return repo.insert(object);
    }

    public List<Client> findAll() {
        return repo.findAll();
    }

    public Client findById(String id) {
        Optional<Client> result = repo.findById(id);
        return result.orElseThrow(() -> new ObjectNotFoundException("Client not found!"));
    }

    public List<Client> findByName(String name) {
        return repo.searchName(name);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public Client updateName(Client clientCurrentData) {
        Client clientNewData = repo.findById(clientCurrentData.getId()).orElseThrow(
                () -> new ObjectNotFoundException("Client not found!")
        );

        // gets only the client's new name
        clientNewData.setName(clientCurrentData.getName());

        return repo.save(clientNewData);
    }
}
