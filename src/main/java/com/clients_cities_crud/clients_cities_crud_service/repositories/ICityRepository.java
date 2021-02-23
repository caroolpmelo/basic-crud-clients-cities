package com.clients_cities_crud.clients_cities_crud_service.repositories;

import com.clients_cities_crud.clients_cities_crud_service.domains.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepository extends MongoRepository<City, String> {
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }") // case insensitive
    List<City> searchName(String name);

    @Query("{ 'state': { $regex: ?0, $options: 'i' } }")
    List<City> searchState(String state);
}
