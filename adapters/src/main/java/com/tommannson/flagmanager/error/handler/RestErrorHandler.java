package com.tommannson.flagmanager.error.handler;

import com.tommannson.flagmanager.error.BindingException;
import com.tommannson.flagmanager.error.InvalidOperationException;
import com.tommannson.flagmanager.error.ResourceNotExistsException;
import com.tommannson.flagmanager.error.response.ErrorsDto;
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
    @ExceptionHandler(value = {BindingException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorsDto validationException(BindingException ex, WebRequest request) {
        return ex.getErrors();
    }

    @ExceptionHandler(value = {InvalidOperationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorsDto validationException(InvalidOperationException ex, WebRequest request) {
        return ex.getErrors();
    }


}
