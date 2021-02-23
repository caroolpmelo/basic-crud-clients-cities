package com.clients_cities_crud.clients_cities_crud_service.services;

import com.clients_cities_crud.clients_cities_crud_service.domains.City;
import com.clients_cities_crud.clients_cities_crud_service.repositories.ICityRepository;
import com.clients_cities_crud.clients_cities_crud_service.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private ICityRepository repo;

    public City insert(City object) {
        return repo.insert(object);
    }

    public List<City> findAll() {
        return repo.findAll();
    }

    public City findById(String id) {
        Optional<City> result = repo.findById(id);
        return result.orElseThrow(() -> new ObjectNotFoundException("City not found!"));
    }

    public List<City> findByName(String name) {
        return repo.searchName(name);
    }

    public List<City> findByState(String state) {
        return repo.searchState(state);
    }
}
