package com.techchallenge.ordermanager.adapters.gateways;


import com.techchallenge.ordermanager.adapters.data.CustomerData;
import com.techchallenge.ordermanager.adapters.repository.CustomerRepository;
import com.techchallenge.ordermanager.core.domain.Customer;
import com.techchallenge.ordermanager.core.domain.valueobjects.Cpf;
import com.techchallenge.ordermanager.core.domain.valueobjects.CustomerId;
import com.techchallenge.ordermanager.core.domain.valueobjects.EmailAddress;
import com.techchallenge.ordermanager.core.domain.valueobjects.PersonName;
import com.techchallenge.ordermanager.core.ports.database.CustomerGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JpaCustomerGateway implements CustomerGateway {

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
