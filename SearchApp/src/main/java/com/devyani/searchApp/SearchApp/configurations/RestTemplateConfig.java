package com.devyani.searchApp.SearchApp.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration for Spring RestTemplate. Gets data from application.yml
 */
@Component
@ConfigurationProperties(prefix = "rest-template-config")
public class RestTemplateConfig {
    /**
     * Connection timeout.
     */
    private int timeout;
    @Autowired
    private RestTemplateResponseErrorHandler errorHandler;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * Provides {@link RestTemplate} as spring bean.
     * @param restTemplateBuilder see {@link RestTemplateBuilder}
     * @return see {@link RestTemplate}
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .requestFactory(this::getClientHttpRequestFactory)
                .errorHandler(errorHandler)
                .build();
    }

    /**
     * Provides HttpRequestFactory.
     * @return see {@link ClientHttpRequestFactory}
     */
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }
}
