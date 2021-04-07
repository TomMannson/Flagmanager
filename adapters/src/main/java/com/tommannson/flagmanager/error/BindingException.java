package com.tommannson.flagmanager.error;

import com.tommannson.flagmanager.error.response.ErrorsDto;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public class BindingException extends RuntimeException {

    List<ErrorsDto.ErrorInfo> errors;

    public BindingException(BindingResult result) {
        errors = result.getFieldErrors()
                .stream()
                .map(error ->
                        new ErrorsDto.ErrorInfo(error.getField(), error.getDefaultMessage())
                )
                .collect(Collectors.toList());
    }

    public ErrorsDto getErrors() {
        return new ErrorsDto("validation_error", errors);
    }


}
