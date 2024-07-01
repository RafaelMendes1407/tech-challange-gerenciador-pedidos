package com.techchallenge.ordermanager.domain.entities.valueobjects;

import java.util.UUID;

public class ProductId extends BaseId<UUID> {
    public ProductId(UUID value) {
        super(value);
    }
}
