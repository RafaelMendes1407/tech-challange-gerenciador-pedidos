package com.techchallenge.ordermanager.configuration;


import com.techchallenge.ordermanager.adapters.gateways.JpaDatabase;
import com.techchallenge.ordermanager.adapters.repository.CustomerRepository;
import com.techchallenge.ordermanager.adapters.repository.OrderRepository;
import com.techchallenge.ordermanager.adapters.repository.ProductRepository;
import com.techchallenge.ordermanager.core.ports.database.Database;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.techchallenge.ordermanager.adapters.data")
@EnableJpaRepositories("com.techchallenge.ordermanager.adapters.repository")
public class ApplicationConfiguration {

    @Bean
    public Database database(ProductRepository productRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        return new JpaDatabase(productRepository, customerRepository, orderRepository);
    }

}
