package com.techchallenge.ordermanager.domain.entities.valueobjects;

import java.util.UUID;

public class CustomerId extends BaseId<UUID> {
    public CustomerId(UUID value) {
        super(value);
    }
}

