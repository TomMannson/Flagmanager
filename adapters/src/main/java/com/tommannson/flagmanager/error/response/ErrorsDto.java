package com.tommannson.flagmanager.error.response;

import com.tommannson.flagmanager.error.BindingException;

import java.util.List;

public class ErrorsDto {
    String errorInfo;
    List<ErrorInfo> errors;

    public ErrorsDto(String generalError, List<ErrorInfo> errors) {
        this.errorInfo = generalError;
        this.errors = errors;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public List<ErrorInfo> getErrors() {
        return errors;
    }

    public static class ErrorInfo {
        String name;
        String info;

        public ErrorInfo(String name, String info) {
            this.name = name;
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public String getInfo() {
            return info;
        }
    }
}
