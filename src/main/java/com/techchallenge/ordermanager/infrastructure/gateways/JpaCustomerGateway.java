package com.techchallenge.ordermanager.infrastructure.gateways;

import com.techchallenge.ordermanager.application.gateways.ICustomerGateway;
import com.techchallenge.ordermanager.domain.entities.Customer;
import com.techchallenge.ordermanager.domain.entities.valueobjects.Cpf;
import com.techchallenge.ordermanager.domain.entities.valueobjects.CustomerId;
import com.techchallenge.ordermanager.domain.entities.valueobjects.EmailAddress;
import com.techchallenge.ordermanager.domain.entities.valueobjects.PersonName;
import com.techchallenge.ordermanager.infrastructure.persistence.data.CustomerData;
import com.techchallenge.ordermanager.infrastructure.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JpaCustomerGateway implements ICustomerGateway {

    private final CustomerRepository customerRepository;

    public JpaCustomerGateway(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll().stream().map(this::mapToCustomer).toList();
    }

    private Customer mapToCustomer(CustomerData customerData) {
        var cpf = new Cpf(customerData.getCpf());
        var email = new EmailAddress(customerData.getEmail());
        var name = new PersonName(customerData.getName());
        var id = new CustomerId(customerData.getId());

        return new Customer(id, cpf, email, name);
    }

    public CustomerId add(Customer customer) {
        UUID id = UUID.randomUUID();
        CustomerData customerData =  new CustomerData(id,
                customer.getCpf().toString(),
                customer.getName().toString(),
                customer.getEmail().toString());
        customerRepository.save(customerData);
        return new CustomerId(id);
    }

    @Override
    public Customer getById(UUID id) {
        return customerRepository.findById(id)
                .map(this::mapToCustomer)
                .orElse(null);
    }

    @Override
    public void update(Customer customer) {
        CustomerData customerData =  new CustomerData(
                customer.getCpf().toString(),
                customer.getName().toString(),
                customer.getEmail().toString());
        customerRepository.save(customerData);    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }

}