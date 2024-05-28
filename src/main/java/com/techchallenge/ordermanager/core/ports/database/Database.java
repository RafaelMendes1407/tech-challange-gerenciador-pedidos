package com.techchallenge.ordermanager.core.ports.database;

public interface Database {
    ProductGateway productGateway();
    CustomerGateway customerGateway();
    OrderGateway orderGateway();
}
