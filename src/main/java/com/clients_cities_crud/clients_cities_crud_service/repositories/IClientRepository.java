package com.clients_cities_crud.clients_cities_crud_service.repositories;

import com.clients_cities_crud.clients_cities_crud_service.domains.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends MongoRepository<Client, String> {
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Client> searchName(String name);
}
