package com.techchallenge.ordermanager.infrastructure.persistence.repository;

import com.techchallenge.ordermanager.infrastructure.persistence.data.CustomerData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface CustomerRepository extends CrudRepository<CustomerData, UUID> {
    List<CustomerData> findAll();
}