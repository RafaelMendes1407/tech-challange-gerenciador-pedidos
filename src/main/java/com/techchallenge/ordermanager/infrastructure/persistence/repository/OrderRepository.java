package com.techchallenge.ordermanager.infrastructure.persistence.repository;

import com.techchallenge.ordermanager.infrastructure.persistence.data.OrderData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<OrderData, UUID> {
    List<OrderData> findAll();
}