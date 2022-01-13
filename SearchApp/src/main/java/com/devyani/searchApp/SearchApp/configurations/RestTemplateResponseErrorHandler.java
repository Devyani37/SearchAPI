package com.devyani.searchApp.SearchApp.configurations;

import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

/**
 * Spring RestTemplate error handler.
 */
@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (
                response.getStatusCode().series() == CLIENT_ERROR
                        || response.getStatusCode().series() == SERVER_ERROR);
    }

    /**
     * Handles RestTemplate communication errors.
     */
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new SearchException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred during db rest call.");
    }
}
