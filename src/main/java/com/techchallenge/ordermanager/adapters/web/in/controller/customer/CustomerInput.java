package com.techchallenge.ordermanager.adapters.web.in.controller.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInput {
    private String name;
    private String cpf;
    private String email;
}