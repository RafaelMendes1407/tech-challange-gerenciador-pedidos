package com.techchallenge.ordermanager.configuration;

import com.techchallenge.ordermanager.application.gateways.Database;
import com.techchallenge.ordermanager.application.usecase.customer.CustomerRegistration;
import com.techchallenge.ordermanager.application.usecase.order.CheckoutOrder;
import com.techchallenge.ordermanager.application.usecase.order.ListOrders;
import com.techchallenge.ordermanager.application.usecase.product.*;
import com.techchallenge.ordermanager.infrastructure.controllers.customer.CustomerRegistrationPresenter;
import com.techchallenge.ordermanager.infrastructure.controllers.order.CheckoutOrderPresenter;
import com.techchallenge.ordermanager.infrastructure.controllers.order.GetListOrderPresenter;
import com.techchallenge.ordermanager.infrastructure.controllers.product.CreateProductPresenter;
import com.techchallenge.ordermanager.infrastructure.controllers.product.FindProductByCategoryPresenter;
import com.techchallenge.ordermanager.infrastructure.controllers.product.GetProductByIdPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    // Customer
    @Bean
    public CustomerRegistration customerRegistration(Database database, CustomerRegistrationPresenter presenter) {
        return new CustomerRegistration(database.customerGateway(), presenter);
    }


    // Product
    @Bean
    public AddProduct productInput(Database database, CreateProductPresenter presenter) {
        return new AddProduct(presenter, database.productGateway());
    }

    @Bean
    public DeleteProduct deleteProduct(Database database) {
        return new DeleteProduct(database.productGateway());
    }

    @Bean
    public EditProduct editProduct(Database database) {
        return new EditProduct(database.productGateway());
    }

    @Bean
    public GetProduct getProduct(Database database, GetProductByIdPresenter presenter) {
        return new GetProduct(presenter, database.productGateway());
    }

    @Bean
    public FindProductByCategory findProductByCategory(Database database, FindProductByCategoryPresenter presenter) {
        return new FindProductByCategory(presenter, database.productGateway());
    }

    // Order
    @Bean
    public ListOrders listOrders(Database database, GetListOrderPresenter presenter) {
        return new ListOrders(database.orderGateway(), presenter);
    }

    @Bean
    public CheckoutOrder checkoutOrder(Database database,  CheckoutOrderPresenter presenter) {
        return new CheckoutOrder(database.orderGateway(), database.productGateway(), presenter);
    }
}
