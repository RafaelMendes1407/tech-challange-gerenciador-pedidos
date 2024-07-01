package com.techchallenge.ordermanager.application.gateways;

public interface Database {
    IProductGateway productGateway();
    ICustomerGateway customerGateway();
    IOrderGateway orderGateway();
}
