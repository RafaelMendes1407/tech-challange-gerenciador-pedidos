package com.techchallenge.ordermanager.application.gateways;

import com.techchallenge.ordermanager.domain.entities.Customer;
import com.techchallenge.ordermanager.domain.entities.valueobjects.CustomerId;

import java.util.List;
import java.util.UUID;

public interface ICustomerGateway {
    List<Customer> getAll();
    CustomerId add(Customer Customer);
    Customer getById(UUID id);
    void update(Customer Customer);
    void delete(UUID id);

    public interface BadRequest {}
    public interface NotFound {}

    public class CustomerAlreadyExistsException extends RuntimeException implements BadRequest {
    }

    public class CustomerNotFoundException extends RuntimeException implements NotFound {
    }
}
