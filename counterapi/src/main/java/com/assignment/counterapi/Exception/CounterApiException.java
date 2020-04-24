package com.assignment.counterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Something went wrong with processing of the request.")
public class CounterApiException extends Exception {
    private static final long serialVersionUID = 1L;

    public CounterApiException(String errorMessage) {
        super(errorMessage);
    }
}