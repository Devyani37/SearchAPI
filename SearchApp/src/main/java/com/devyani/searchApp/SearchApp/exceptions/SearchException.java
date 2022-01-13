package com.devyani.searchApp.SearchApp.exceptions;

import org.springframework.http.HttpStatus;

public class SearchException extends RuntimeException {

    private HttpStatus code;

    public SearchException(HttpStatus code, String msg) {
        super(msg);
        this.code = code;
    }

    public SearchException(HttpStatus code, String msg, Throwable t) {
        super(msg, t);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}
