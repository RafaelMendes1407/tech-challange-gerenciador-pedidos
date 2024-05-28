package com.techchallenge.ordermanager.adapters.repository;

import com.techchallenge.ordermanager.adapters.data.CustomerData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface CustomerRepository extends CrudRepository<CustomerData, UUID> {
    List<CustomerData> findAll();
}
