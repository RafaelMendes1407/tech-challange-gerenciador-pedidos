package com.techchallenge.ordermanager.adapters.gateways;

import com.techchallenge.ordermanager.adapters.repository.CustomerRepository;
import com.techchallenge.ordermanager.adapters.repository.OrderRepository;
import com.techchallenge.ordermanager.adapters.repository.ProductRepository;
import com.techchallenge.ordermanager.core.ports.database.CustomerGateway;
import com.techchallenge.ordermanager.core.ports.database.Database;
import com.techchallenge.ordermanager.core.ports.database.OrderGateway;
import com.techchallenge.ordermanager.core.ports.database.ProductGateway;

public class JpaDatabase implements Database {

    private ProductGateway productGateway;
    private CustomerGateway customerGateway;
    private OrderGateway orderGateway;

    public JpaDatabase(ProductRepository productRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        productGateway = new JpaProductGateway(productRepository);
        customerGateway = new JpaCustomerGateway(customerRepository);
        orderGateway = new JpaOrderGateway(orderRepository);
    }

    @Override
    public ProductGateway productGateway() {
        return this.productGateway;
    }

    @Override
    public CustomerGateway customerGateway() {
        return this.customerGateway;
    }

    @Override
    public OrderGateway orderGateway() {
        return this.orderGateway;
    }
}
