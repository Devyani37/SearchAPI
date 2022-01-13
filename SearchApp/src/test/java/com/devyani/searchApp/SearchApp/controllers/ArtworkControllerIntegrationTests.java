package com.devyani.searchApp.SearchApp.controllers;

import com.devyani.searchApp.SearchApp.dtos.ArtworkSearchResponse;
import com.devyani.searchApp.SearchApp.dtos.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;

public class ArtworkControllerIntegrationTests extends SearchApiBaseIntegrationTest {

    private static final String PATH = "/artworks";
    private static final String TITLE_PARAM = "title";
    private static final String CONSTITUTE_ID_PARAM = "constituentId";
    private static final String ARTIST_PARAM = "artist";
    private static final String ARTIST_BIO_PARAM = "artistsBio";
    private static final String GENDER_PARAM = "gender";
    private static final String BEGINYEAR_PARAM = "beginYear";
    private static final String ENDYEAR_PARAM = "endYear";
    private static final String MEDIUM_PARAM = "medium";
    private static final String CREDIT_LINE_PARAM = "creditLine";
    private static final String ACCESSION_PARAM = "accessionNumber";
    private static final String CLASSIFICATION_PARAM = "classification";
    private static final String OBJECT_ID_PARAM = "objectId";

    @Test
    public void search_Artworks_Success() {
        var response = given()
                .queryParam(OBJECT_ID_PARAM, 5)
                .when()
                .get(PATH)
                .then()
                .assertThat().statusCode(HttpStatus.OK.value())
                .extract().asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(List.of(sampleArtWorkResponse()));

    }

    @Test
    public void searchArtworks_All_Params_Success() {

        var response = given()
                .queryParam(TITLE_PARAM, "The Manhattan Transcripts Project, New York, New York, Introductory panel to Episode 1: The Park")
                .queryParam(CONSTITUTE_ID_PARAM, 7056)
                .queryParam(ARTIST_PARAM, "Bernard Tschumi")
                .queryParam(ARTIST_BIO_PARAM, "French and Swiss, born Switzerland 1944")
                .queryParam(ENDYEAR_PARAM, 0)
                .queryParam(GENDER_PARAM, "Male")
                .queryParam(BEGINYEAR_PARAM, 1944)
                .queryParam(MEDIUM_PARAM, "Photographic reproduction with colored synthetic laminate")
                .queryParam(CREDIT_LINE_PARAM, "Purchase and partial gift of the architect in honor of Lily Auchincloss")
                .queryParam(ACCESSION_PARAM, "2.1995")
                .queryParam(CLASSIFICATION_PARAM, "Architecture")
                .queryParam(OBJECT_ID_PARAM, 5)
                .when()
                .get(PATH)
                .then()
                .assertThat().statusCode(HttpStatus.OK.value())
                .extract()
                .asString();

        assertThatJson(response)
                .when(IGNORING_ARRAY_ORDER)
                .isEqualTo(List.of(sampleArtWorkResponse()));

    }

    @Test
    public void search_Artworks_not_exist() {

        var expectedResponse = new ErrorResponse(HttpStatus.NOT_FOUND, List.of("Artwork Not Found"));


        var response = given()
                .queryParam(OBJECT_ID_PARAM, 10000000)
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
    public void search_Artworks_EmptyRequest_Failure() {

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


    public ArtworkSearchResponse sampleArtWorkResponse() {

        var expectedResponse = new ArtworkSearchResponse();
        expectedResponse.setTitle("The Manhattan Transcripts Project, New York, New York, Introductory panel to Episode 1: The Park");
        expectedResponse.setArtists(List.of("Bernard Tschumi"));
        expectedResponse.setConstituentId(List.of(7056));
        expectedResponse.setArtistsBio(List.of("French and Swiss, born Switzerland 1944"));
        expectedResponse.setNationality(List.of());
        expectedResponse.setBeginDate(List.of(1944));
        expectedResponse.setEndDate(List.of(0));
        expectedResponse.setGender(List.of("Male"));
        expectedResponse.setArtworkDate("1980");
        expectedResponse.setMedium("Photographic reproduction with colored synthetic laminate");
        expectedResponse.setDimensions("20 x 20\" (50.8 x 50.8 cm)");
        expectedResponse.setCreditLine("Purchase and partial gift of the architect in honor of Lily Auchincloss");
        expectedResponse.setAccessionNumber("2.1995");
        expectedResponse.setClassification("Architecture");
        expectedResponse.setDepartment("Architecture & Design");
        expectedResponse.setCataloged("Y");
        expectedResponse.setUrl("http://www.moma.org/collection/works/5");
        expectedResponse.setThumbnail("http://www.moma.org/media/W1siZiIsIjEyNCJdLFsicCIsImNvbnZlcnQiLCItcmVzaXplIDMwMHgzMDBcdTAwM2UiXV0.jpg?sha=c89b9071486760a5");
        expectedResponse.setHeight(50.8);
        expectedResponse.setWidth(50.8);
        expectedResponse.setObjectId(5);
        expectedResponse.setDateAcquired("1995-01-17");

        return expectedResponse;
    }
}
