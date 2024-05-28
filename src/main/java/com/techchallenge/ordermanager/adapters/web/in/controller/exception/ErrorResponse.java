package com.techchallenge.ordermanager.adapters.web.in.controller.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
public class ErrorResponse {
    @Singular(value = "addError") private List<String> errors;
}

