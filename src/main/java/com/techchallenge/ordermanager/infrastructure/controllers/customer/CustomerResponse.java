package com.techchallenge.ordermanager.infrastructure.controllers.customer;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private String cpf;
    private String name;
    private String id;
    private String email;
}
