package com.devyani.searchApp.SearchApp.controllers;

import com.devyani.searchApp.SearchApp.dtos.ErrorResponse;
import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller Exceptions Handler
 */
@ControllerAdvice
public class ErrorHandler {

    Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    /**
     * Handler for all generic exceptions
     *
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericHandler(Exception exception) {
        logger.error("Generic Exception Handler", exception);

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, List.of("Server Error"));

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    /**
     * Handler for spring BindException
     *
     * @param exception see {@link BindException}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException exception) {

        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ":" + e.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, errors);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }

    /**
     * Handler for IllegalArgument Exceptions
     *
     * @param exception see {@link IllegalArgumentException}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, List.of(exception.getMessage()));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    /**
     * Handler for Search Exceptions
     *
     * @param exception see {@link SearchException}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(SearchException.class)
    public ResponseEntity<ErrorResponse> handleSearchException(SearchException exception) {

        ErrorResponse errorResponse;

        switch (exception.getCode()) {
            case NOT_FOUND:
                errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, List.of(exception.getMessage()));
                break;
            default:
                logger.error("Search server error", exception);
                errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, List.of("Server Error"));
        }

        return ResponseEntity
                .status(errorResponse.getStatusCode())
                .body(errorResponse);
    }
}
