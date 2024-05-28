package com.techchallenge.ordermanager.core.usecase.product;

public interface GetProduct<T> {
    void execute(T productId);
}
