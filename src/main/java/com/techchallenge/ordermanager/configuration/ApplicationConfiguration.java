package com.techchallenge.ordermanager.configuration;


import com.techchallenge.ordermanager.application.gateways.Database;

import com.techchallenge.ordermanager.infrastructure.gateways.JpaDatabase;
import com.techchallenge.ordermanager.infrastructure.persistence.repository.CustomerRepository;
import com.techchallenge.ordermanager.infrastructure.persistence.repository.OrderRepository;
import com.techchallenge.ordermanager.infrastructure.persistence.repository.ProductRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.techchallenge.ordermanager.adapters.data")
@EnableJpaRepositories("com.techchallenge.ordermanager.infrastructure.persistence.repository")
public class ApplicationConfiguration {

    @Bean
    public Database database(ProductRepository productRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        return new JpaDatabase(productRepository, customerRepository, orderRepository);
    }

}
