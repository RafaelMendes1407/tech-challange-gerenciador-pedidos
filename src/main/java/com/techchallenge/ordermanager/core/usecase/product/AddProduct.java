package com.techchallenge.ordermanager.core.usecase.product;

public interface AddProduct<T> {
    void execute(T product);
}
