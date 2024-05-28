package com.techchallenge.ordermanager.configuration;

import com.techchallenge.ordermanager.adapters.presenter.customer.CustomerRegistrationPresenter;
import com.techchallenge.ordermanager.adapters.presenter.order.ListOrderPresenter;
import com.techchallenge.ordermanager.adapters.presenter.order.OrderPresenter;
import com.techchallenge.ordermanager.adapters.presenter.product.ListProductPresenter;
import com.techchallenge.ordermanager.adapters.presenter.product.ProductPresenter;
import com.techchallenge.ordermanager.adapters.usecase.customer.CustomerRegistrationUseCase;
import com.techchallenge.ordermanager.adapters.usecase.order.CheckoutOrderUsecase;
import com.techchallenge.ordermanager.adapters.usecase.order.ListOrdersUseCase;
import com.techchallenge.ordermanager.adapters.usecase.product.*;
import com.techchallenge.ordermanager.adapters.web.in.controller.customer.CustomerInput;
import com.techchallenge.ordermanager.adapters.web.in.controller.product.ProductInput;
import com.techchallenge.ordermanager.core.ports.database.Database;
import com.techchallenge.ordermanager.core.usecase.customer.CustomerRegistration;
import com.techchallenge.ordermanager.core.usecase.order.CheckoutOrder;
import com.techchallenge.ordermanager.core.usecase.order.ListOrders;
import com.techchallenge.ordermanager.core.usecase.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class UseCaseConfiguration {

    // Customer
    @Bean
    public CustomerRegistration<CustomerInput> customerRegistration(Database database, CustomerRegistrationPresenter presenter) {
        return new CustomerRegistrationUseCase(presenter, database.customerGateway());
    }


    // Product
    @Bean
    public AddProduct<ProductInput> productInput(Database database, ProductPresenter presenter) {
        return new AddProductUseCase(presenter, database.productGateway());
    }

    @Bean
    public DeleteProduct<UUID> deleteProduct(Database database) {
        return new DeleteProductUseCase(database.productGateway());
    }

    @Bean
    public EditProduct<ProductInput> editProduct(Database database) {
        return new EditProductUseCase(database.productGateway());
    }

    @Bean
    public GetProduct<UUID> getProduct(Database database, ProductPresenter presenter) {
        return new GetProductUseCase(presenter, database.productGateway());
    }

    @Bean
    public FindProductByCategory<ProductInput> findProductByCategory(Database database, ListProductPresenter presenter) {
        return new FindProductByCategoryUseCase(presenter, database.productGateway());
    }

    // Order
    @Bean
    public ListOrders listOrders(Database database, ListOrderPresenter presenter) {
        return new ListOrdersUseCase(presenter, database.orderGateway());
    }

    @Bean
    public CheckoutOrder checkoutOrder(Database database,  OrderPresenter presenter) {
        return new CheckoutOrderUsecase(presenter, database.orderGateway(), database.productGateway());
    }
}
