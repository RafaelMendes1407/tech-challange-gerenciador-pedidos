package com.techchallenge.ordermanager.core.usecase.product;

public interface DeleteProduct<T> {
    void execute(T product);
}
