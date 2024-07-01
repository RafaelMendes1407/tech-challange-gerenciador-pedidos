package com.techchallenge.ordermanager.application.presenters;

public interface IOrderPresenter<T, B> {

    T output(B order);
    T getViewModel();

}
