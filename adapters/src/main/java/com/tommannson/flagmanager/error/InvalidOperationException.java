package com.tommannson.flagmanager.error;

import com.tommannson.flagmanager.error.response.ErrorsDto;

import java.util.ArrayList;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message) {
        super(message);
    }

    public ErrorsDto getErrors() {
        return new ErrorsDto(getMessage(), new ArrayList<>());
    }
}
