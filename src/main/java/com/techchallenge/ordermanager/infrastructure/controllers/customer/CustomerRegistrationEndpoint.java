package com.techchallenge.ordermanager.infrastructure.controllers.customer;

import com.techchallenge.ordermanager.application.usecase.customer.CustomerRegistration;
import com.techchallenge.ordermanager.infrastructure.controllers.IBaseEndpoint;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.text.MessageFormat;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerRegistrationEndpoint implements IBaseEndpoint {

    private CustomerRegistration usecase;
    private CustomerRegistrationPresenter presenter;

    @PostMapping
    public ResponseEntity execute(@RequestBody CustomerRequest customerRequest) {
        usecase.execute(customerRequest.toCustomer());
        return ResponseEntity.created(
                URI.create(
                        MessageFormat.format("/api/v1/customers/{0}", presenter.getViewModel().getId())
                )).body(presenter.getViewModel());
    }

}