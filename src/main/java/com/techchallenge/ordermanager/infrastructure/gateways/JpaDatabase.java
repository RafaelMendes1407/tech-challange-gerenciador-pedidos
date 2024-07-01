package com.techchallenge.ordermanager.infrastructure.gateways;

import com.techchallenge.ordermanager.application.gateways.Database;
import com.techchallenge.ordermanager.application.gateways.ICustomerGateway;
import com.techchallenge.ordermanager.application.gateways.IOrderGateway;
import com.techchallenge.ordermanager.application.gateways.IProductGateway;
import com.techchallenge.ordermanager.infrastructure.persistence.repository.CustomerRepository;
import com.techchallenge.ordermanager.infrastructure.persistence.repository.OrderRepository;
import com.techchallenge.ordermanager.infrastructure.persistence.repository.ProductRepository;

public class JpaDatabase implements Database {

    private IProductGateway productGateway;
    private ICustomerGateway customerGateway;
    private IOrderGateway orderGateway;

    public JpaDatabase(ProductRepository productRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        productGateway = new JpaProductGateway(productRepository);
        customerGateway = new JpaCustomerGateway(customerRepository);
        orderGateway = new JpaOrderGateway(orderRepository);
    }

    @Override
    public IProductGateway productGateway() {
        return this.productGateway;
    }

    @Override
    public ICustomerGateway customerGateway() {
        return this.customerGateway;
    }

    @Override
    public IOrderGateway orderGateway() {
        return this.orderGateway;
    }
}