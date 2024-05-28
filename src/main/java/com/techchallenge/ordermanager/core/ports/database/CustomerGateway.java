package com.techchallenge.ordermanager.core.ports.database;

import com.techchallenge.ordermanager.core.domain.Customer;
import com.techchallenge.ordermanager.core.domain.valueobjects.CustomerId;

import java.util.List;
import java.util.UUID;

public interface CustomerGateway {
    List<Customer> getAll();
    CustomerId add(Customer Customer);
    Customer getById(UUID id);
    void update(Customer Customer);
    void delete(UUID id);

    public interface BadRequest {}
    public interface NotFound {}

    public class CustomerAlreadyByNameExistsException extends RuntimeException implements BadRequest {
    }

    public class CustomerNotFoundException extends RuntimeException implements NotFound {
    }
}
