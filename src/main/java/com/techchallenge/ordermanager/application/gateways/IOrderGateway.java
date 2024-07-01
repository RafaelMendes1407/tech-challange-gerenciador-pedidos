package com.techchallenge.ordermanager.application.gateways;

import com.techchallenge.ordermanager.domain.entities.Order;
import com.techchallenge.ordermanager.domain.entities.valueobjects.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface IOrderGateway {
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
