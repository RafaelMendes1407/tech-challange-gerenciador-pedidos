package com.techchallenge.ordermanager.core.ports.out;

public interface IPresenter<T, B> {
    T getViewModel();

    void output(B object);
}
