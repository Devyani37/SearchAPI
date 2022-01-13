package com.devyani.searchApp.SearchApp.repositories;

import com.devyani.searchApp.SearchApp.configurations.PouchDbConfig;
import com.devyani.searchApp.SearchApp.dtos.ArtworkSearchRequest;
import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import com.devyani.searchApp.SearchApp.models.Artwork;
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
public class ArtworkRepository {

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
     * Search artwork in database as per search request.
     *
     * @param request see {@link ArtworkSearchRequest}
     * @return List of Artwork or empty list in case of empty response from database.
     */
    public List<Artwork> findArtworks(ArtworkSearchRequest request) {
        var searchUrl = pouchDbConfig.getHost() + "/" + pouchDbConfig.getArtworkdb() + "/_find";

        ObjectNode requestBody = OBJECT_MAPPER.createObjectNode();
        requestBody.set("selector", buildQuery(request));

        var response = restTemplate.postForEntity(searchUrl, requestBody, ObjectNode.class);

        if (response.hasBody()) {
            return toArtworks(response.getBody());
        }

        return List.of();
    }

    /**
     * Convert Artwork search JSON response to List of {@link Artwork}
     *
     * @param searchResponse Search response json body as {@link ObjectNode}
     * @return List of Artwork.
     */
    private List<Artwork> toArtworks(ObjectNode searchResponse) {
        var docs = searchResponse.get(DOCS_FIELD);
        List<Artwork> result = new ArrayList<>();

        for (JsonNode item : docs) {
            try {
                var artwork = OBJECT_MAPPER.treeToValue(item, Artwork.class);
                result.add(artwork);
            } catch (JsonProcessingException e) {
                throw new SearchException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception occurred while mapping to artwork model.");
            }
        }
        return result;
    }

    /**
     * Build search query based on {@link ArtworkSearchRequest}.
     * Usages $elemMatch to match at least one element in array and $regex for wildcard search.
     *
     * @param request see {@link ArtworkSearchRequest}
     * @return search query json body as {@link ObjectNode}
     */
    private ObjectNode buildQuery(ArtworkSearchRequest request) {
        ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();

        if (StringUtils.isNotEmpty(request.getAccessionNumber())) {
            objectNode.put("AccessionNumber", request.getAccessionNumber());
        }

        if (request.getObjectId() != null) {
            objectNode.put("ObjectID", request.getObjectId());
        }

        if (StringUtils.isNotEmpty(request.getClassification())) {
            objectNode.put("Classification", request.getClassification());
        }

        if (StringUtils.isNotEmpty(request.getArtist())) {
            objectNode.set("Artist",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$elemMatch", request.getArtist()));
        }

        if (request.getConstituentId() != null) {
            objectNode.set("ConstituentID",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$elemMatch", request.getConstituentId()));
        }

        if (StringUtils.isNotEmpty(request.getNationality())) {
            objectNode.set("Nationality",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$elemMatch", request.getNationality()));
        }

        if (request.getBeginDate() != null) {
            objectNode.set("BeginDate",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$elemMatch", request.getBeginDate()));
        }

        if (request.getEndDate() != null) {
            objectNode.set("EndDate",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$elemMatch", request.getEndDate()));
        }

        if (StringUtils.isNotEmpty(request.getGender())) {
            objectNode.set("Gender",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$elemMatch", request.getGender()));
        }

        if (StringUtils.isNotEmpty(request.getTitle())) {
            objectNode.set("Title",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$regex", "^.*" + request.getTitle() + ".*$"));
        }

        if (StringUtils.isNotEmpty(request.getArtistsBio())) {
            objectNode.set("ArtistBio",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$regex", "^.*" + request.getArtistsBio() + ".*$"));
        }

        if (StringUtils.isNotEmpty(request.getMedium())) {
            objectNode.set("Medium",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$regex", "^.*" + request.getMedium() + ".*$"));
        }

        if (StringUtils.isNotEmpty(request.getCreditLine())) {
            objectNode.set("CreditLine",
                    OBJECT_MAPPER.createObjectNode()
                            .put("$regex", "^.*" + request.getCreditLine() + ".*$"));
        }

        return objectNode;
    }

}
