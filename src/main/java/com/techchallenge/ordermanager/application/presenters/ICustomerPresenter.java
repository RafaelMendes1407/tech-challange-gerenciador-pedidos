package com.techchallenge.ordermanager.application.presenters;

public interface ICustomerPresenter<T, B> {

    T output(B customer);
    T getViewModel();

}
