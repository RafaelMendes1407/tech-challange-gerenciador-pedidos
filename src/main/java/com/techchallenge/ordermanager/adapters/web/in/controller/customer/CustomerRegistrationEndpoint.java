package com.techchallenge.ordermanager.adapters.web.in.controller.customer;


import com.techchallenge.ordermanager.adapters.presenter.customer.CustomerRegistrationPresenter;
import com.techchallenge.ordermanager.adapters.web.in.controller.BaseEndpoint;
import com.techchallenge.ordermanager.core.usecase.customer.CustomerRegistration;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.MessageFormat;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerRegistrationEndpoint implements BaseEndpoint {

    private CustomerRegistration<CustomerInput> usecase;
    private CustomerRegistrationPresenter presenter;


    @PostMapping
    public ResponseEntity execute(@RequestBody CustomerInput customer) {
        usecase.execute(customer);
        return ResponseEntity.created(
                URI.create(
                MessageFormat.format("/api/v1/customers/{0}", presenter.getViewModel().getId())
        )).body(presenter.getViewModel());
    }

}
