package com.devyani.searchApp.SearchApp.repositories;

import com.devyani.searchApp.SearchApp.configurations.PouchDbConfig;
import com.devyani.searchApp.SearchApp.dtos.ArtistSearchRequest;
import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import com.devyani.searchApp.SearchApp.models.Artist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Artist data repository.
 */
@Repository
public class ArtistRepository {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PouchDbConfig pouchDbConfig;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    /**
     * DB search response contains results as "docs" array.
     */
    private static final String DOCS_FIELD = "docs";

    /**
     * Search artist in database as per search request.
     *
     * @param request see {@link ArtistSearchRequest}
     * @return List of Artist or empty list in case of empty response from database.
     */
    public List<Artist> find(ArtistSearchRequest request) {

        var searchUrl = pouchDbConfig.getHost() + "/" + pouchDbConfig.getArtistdb() + "/_find";


        ObjectNode requestBody = OBJECT_MAPPER.createObjectNode();
        requestBody.set("selector", buildQuery(request));

        var response = restTemplate.postForEntity(searchUrl, requestBody, ObjectNode.class);

        if (response.hasBody()) {
            return toArtists(response.getBody());
        }

        return List.of();
    }

    /**
     * Convert Artist search JSON response to List of {@link Artist}
     *
     * @param searchResponse Search response json body as {@link ObjectNode}
     * @return List of Artist.
     */
    private List<Artist> toArtists(ObjectNode searchResponse) {
        var docs = searchResponse.get(DOCS_FIELD);
        List<Artist> result = new ArrayList<>();

        for (JsonNode item : docs) {
            try {
                var artist = OBJECT_MAPPER.treeToValue(item, Artist.class);
                result.add(artist);
            } catch (JsonProcessingException e) {
                throw new SearchException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception occurred while mapping to artist model.");
            }
        }
        return result;
    }

    /**
     * Build search query based on {@link ArtistSearchRequest}.
     *
     * @param request see {@link ArtistSearchRequest}
     * @return search query json body as {@link ObjectNode}
     */
    private ObjectNode buildQuery(ArtistSearchRequest request) {
        ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();

        if (request.getId() != null) {
            objectNode.put("ConstituentID", request.getId());
        }

        if (StringUtils.isNotEmpty(request.getName())) {
            objectNode.put("DisplayName", request.getName());
        }

        if (StringUtils.isNotEmpty(request.getNationality())) {
            objectNode.put("Nationality", request.getNationality());
        }

        if (StringUtils.isNotEmpty(request.getGender())) {
            objectNode.put("Gender", request.getGender());
        }

        if (request.getBeginYear() != null) {
            objectNode.put("BeginDate", request.getBeginYear());
        }

        if (request.getEndYear() != null) {
            objectNode.put("EndDate", request.getEndYear());
        }

        if (StringUtils.isNotEmpty(request.getWikiQID())) {
            objectNode.put("Wiki QID", request.getWikiQID());
        }

        return objectNode;
    }

}
