package com.techchallenge.ordermanager.application.presenters;

public interface IProductPresenter<T, B> {

    T output(B product);
    T getViewModel();
}
