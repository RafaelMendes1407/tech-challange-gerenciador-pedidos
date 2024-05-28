package com.techchallenge.ordermanager.adapters.presenter.customer;

import com.techchallenge.ordermanager.core.ports.out.IPresenter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerRegistrationPresenter implements IPresenter<CustomerRegistrationPresenter.CustomerOutput, UUID> {

    private CustomerOutput viewModel;

    @Override
    public CustomerOutput getViewModel() {
        return viewModel;
    }

    @Override
    public void output(UUID id) {
        this.viewModel = new CustomerOutput(id);
    }

    @Getter
    @AllArgsConstructor
    public static class CustomerOutput {
        private UUID id;
    }

}


