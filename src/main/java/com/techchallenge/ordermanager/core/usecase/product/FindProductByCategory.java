package com.techchallenge.ordermanager.core.usecase.product;

public interface FindProductByCategory<T> {
    void execute(T category);
}
