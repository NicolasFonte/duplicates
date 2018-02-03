package com.nicolasf.duplicates.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Value not found.")
public class ValueNotFoundException extends Exception {

    public ValueNotFoundException(String msg) {
        super(msg);
    }
}
