package com.devyani.searchApp.SearchApp.controllers;

import com.devyani.searchApp.SearchApp.SearchAppApplication;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = {SearchAppApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class SearchApiBaseIntegrationTest {
    /**
     * This will match any of these whitespaces
     * e.g. space (_), the tab (\t), the new line (\n) and the carriage return (\r).
     */
    protected static final String WHITESPACE_REGEX = "\\s";
    protected static final Faker faker = new Faker();

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }
}
