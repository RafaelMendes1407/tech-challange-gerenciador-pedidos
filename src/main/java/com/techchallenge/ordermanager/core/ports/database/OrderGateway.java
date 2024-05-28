package com.techchallenge.ordermanager.core.ports.database;

import com.techchallenge.ordermanager.core.domain.Order;
import com.techchallenge.ordermanager.core.domain.valueobjects.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface OrderGateway {
    List<Order> getAll();
    List<Order> getAllExceptFinished();
    Order add(Order order);
    Order getById(UUID id);
    void updateStatus(UUID id, OrderStatus paymentStatus);
    public interface BadRequest {}
    public interface NotFound {}


    public class OrderNotFoundException extends RuntimeException implements NotFound {
    }

}
