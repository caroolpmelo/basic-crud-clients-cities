package com.clients_cities_crud.clients_cities_crud_service.controllers;

import com.clients_cities_crud.clients_cities_crud_service.domains.City;
import com.clients_cities_crud.clients_cities_crud_service.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService service;

    @PostMapping("/cities")
    public ResponseEntity<Void> insert(@RequestBody City newCity) {
        City cityObj = service.insert(newCity);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cityObj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> findAll() {
        List<City> cityList = service.findAll();

        return ResponseEntity.ok().body(cityList);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> findById(@PathVariable String id) {
        City cityObj = service.findById(id);

        return ResponseEntity.ok().body(cityObj);
    }

    @GetMapping("/cities/name/{name}")
    public ResponseEntity<List<City>> findByName(@PathVariable String name) {
        List<City> cityListObj = service.findByName(name);

        return ResponseEntity.ok().body(cityListObj);
    }

    @GetMapping("/cities/state/{state}")
    public ResponseEntity<List<City>> findByState(@PathVariable String state) {
        List<City> cityListObj = service.findByState(state);

        return ResponseEntity.ok().body(cityListObj);
    }
}
