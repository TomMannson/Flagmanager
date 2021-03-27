package com.tommannson.flagmanager.error;

import com.tommannson.flagmanager.flags.error.ResourceNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(value = {ResourceNotExistsException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void resourceNotFoundException(ResourceNotExistsException ex, WebRequest request) {

    }
}
