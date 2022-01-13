package com.devyani.searchApp.SearchApp.controllers;

import com.devyani.searchApp.SearchApp.dtos.ArtistSearchResponse;
import com.devyani.searchApp.SearchApp.dtos.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;

public class ArtistControllerIntegrationTests extends SearchApiBaseIntegrationTest {

    private static final String PATH = "/artists";
    private static final String ID_PARAM = "id";
    private static final String NAME_PARAM = "name";
    private static final String NATIONALITY_PARAM = "nationality";
    private static final String GENDER_PARAM = "gender";
    private static final String BEGINYEAR_PARAM = "beginYear";
    private static final String ENDYEAR_PARAM = "endYear";
    private static final String WIKIQUID_PARAM = "wikiQID";


    @Test
    public void search_Artists_Success() {

        var expectedResponse = new ArtistSearchResponse();
        expectedResponse.setConstituentId(1);
        expectedResponse.setDisplayName("Robert Arneson");
        expectedResponse.setArtistBio("American, 1930–1992");
        expectedResponse.setNationality("American");
        expectedResponse.setGender("Male");
        expectedResponse.setBeginDate(1930);
        expectedResponse.setEndDate(1992);


        var response = given()
                .queryParam(ID_PARAM, 1)
                .when()
                .get(PATH)
                .then()
                .assertThat().statusCode(HttpStatus.OK.value())
                .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(List.of(expectedResponse));

    }

    @Test
    public void search_Artists_all_params_Success() {

        var expectedResponse = new ArtistSearchResponse();
        expectedResponse.setConstituentId(10);
        expectedResponse.setDisplayName("Irene Aronson");
        expectedResponse.setArtistBio("American, born Germany 1918");
        expectedResponse.setNationality("American");
        expectedResponse.setGender("Female");
        expectedResponse.setBeginDate(1918);
        expectedResponse.setEndDate(0);
        expectedResponse.setWikiQID("Q19748568");
        expectedResponse.setUlan("500042413");


        var response = given()
                .queryParam(ID_PARAM, 10)
                .queryParam(NAME_PARAM, "Irene Aronson")
                .queryParam(NATIONALITY_PARAM, "American")
                .queryParam(GENDER_PARAM, "Female")
                .queryParam(BEGINYEAR_PARAM, 1918)
                .queryParam(ENDYEAR_PARAM, 0)
                .queryParam(WIKIQUID_PARAM, "Q19748568")
                .when()
                .get(PATH)
                .then()
                .assertThat().statusCode(HttpStatus.OK.value())
                .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(List.of(expectedResponse));

    }

    @Test
    public void search_Artists_not_exist() {

        var expectedResponse = new ErrorResponse(HttpStatus.NOT_FOUND, List.of("Artist Not Found"));


        var response = given()
                .queryParam(ID_PARAM, 10000000)
                .when()
                .get(PATH)
                .then()
                .assertThat().statusCode(HttpStatus.NOT_FOUND.value())
                .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(expectedResponse);

    }

    @Test
    public void search_Artists_EmptyRequest_Failure() {

        var expectedResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, List.of("Must have at least one fields to search"));

        var response = given()
                .when()
                .get(PATH)
                .then()
                .assertThat().statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(expectedResponse);

    }

    @Test
    public void search_Artists_InvalidInputs_Failure() {
        var expectedResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,
                List.of("beginYear:must be greater than or equal to 0",
                        "endYear:must be greater than or equal to 0",
                        "id:must be greater than or equal to 1",
                        "gender:Must not be blank",
                        "nationality:Must not be blank",
                        "wikiQID:Must not be blank",
                        "name:Must not be blank"));

        var response = given()
                .queryParam(ID_PARAM, faker.number().numberBetween(Integer.MIN_VALUE, 0))
                .queryParam(NAME_PARAM, faker.regexify(WHITESPACE_REGEX))
                .queryParam(NATIONALITY_PARAM, faker.regexify(WHITESPACE_REGEX))
                .queryParam(GENDER_PARAM, faker.regexify(WHITESPACE_REGEX))
                .queryParam(BEGINYEAR_PARAM, faker.number().numberBetween(Integer.MIN_VALUE, -1))
                .queryParam(ENDYEAR_PARAM, faker.number().numberBetween(Integer.MIN_VALUE, -1))
                .queryParam(WIKIQUID_PARAM, faker.regexify(WHITESPACE_REGEX))

                .when()
                .get(PATH)
                .then()
                .assertThat().statusCode(HttpStatus.BAD_REQUEST.value())
                .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(expectedResponse);

    }
}
