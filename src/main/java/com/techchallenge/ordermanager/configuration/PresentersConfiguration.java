package com.techchallenge.ordermanager.configuration;

import com.techchallenge.ordermanager.adapters.presenter.customer.CustomerRegistrationPresenter;
import com.techchallenge.ordermanager.adapters.presenter.order.ListOrderPresenter;
import com.techchallenge.ordermanager.adapters.presenter.order.OrderPresenter;
import com.techchallenge.ordermanager.adapters.presenter.product.ListProductPresenter;
import com.techchallenge.ordermanager.adapters.presenter.product.ProductPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentersConfiguration {

    @Bean
    public CustomerRegistrationPresenter customerRegistrationPresenter() {
        return new CustomerRegistrationPresenter();
    }

    @Bean
    public ProductPresenter productPresenter() {
        return new ProductPresenter();
    }

    @Bean
    public ListProductPresenter listProductPresenter() {
        return new ListProductPresenter();
    }

    @Bean
    public OrderPresenter orderPresenter() {
        return new OrderPresenter();
    }

    @Bean
    public ListOrderPresenter listOrderPresenter() {
        return new ListOrderPresenter();
    }

}
