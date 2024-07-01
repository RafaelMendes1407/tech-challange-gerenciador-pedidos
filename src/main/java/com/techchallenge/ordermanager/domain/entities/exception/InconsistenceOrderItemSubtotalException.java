package com.techchallenge.ordermanager.domain.entities.exception;

public class InconsistenceOrderItemSubtotalException extends DomainException {

    public InconsistenceOrderItemSubtotalException(String message) {
        super(message);
    }

    public InconsistenceOrderItemSubtotalException(String message, Throwable cause) {
        super(message, cause);
    }
}