package com.devyani.searchApp.SearchApp.dtos;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * API Error Response.
 */
public class ErrorResponse {
    @NotNull
    private HttpStatus statusCode;
    @NotEmpty
    private List<String> message;

    public ErrorResponse(HttpStatus statusCode, List<String> message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public List<String> getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorResponse)) return false;
        ErrorResponse that = (ErrorResponse) o;
        return getStatusCode() == that.getStatusCode() &&
                getMessage().equals(that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusCode(), getMessage());
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "statusCode=" + statusCode +
                ", message=" + message +
                '}';
    }
}
