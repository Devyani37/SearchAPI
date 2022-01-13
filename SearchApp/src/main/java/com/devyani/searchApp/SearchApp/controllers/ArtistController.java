package com.devyani.searchApp.SearchApp.controllers;

import com.devyani.searchApp.SearchApp.dtos.ArtistSearchRequest;
import com.devyani.searchApp.SearchApp.dtos.ArtistSearchResponse;
import com.devyani.searchApp.SearchApp.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * API Controller for Artist resource.
 */
@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    /**
     * Find Artist based on input params. At least one search params must be provided.
     * @param params see {@link ArtistSearchRequest}
     * @return List of Artists.
     */
    @GetMapping("/artists")
    public List<ArtistSearchResponse> findArtist(@Valid ArtistSearchRequest params) {
        if (isEveryParamsNull(params)) {
            throw new IllegalArgumentException("Must have at least one fields to search");
        }
        return artistService.find(params);
    }

    /**
     * Validate if all artist search params are null.
     * @param params see {@link ArtistSearchRequest}
     * @return true if all search params are null, false otherwise.
     */
    private boolean isEveryParamsNull(ArtistSearchRequest params) {
        return params.getId() == null
                && params.getBeginYear() == null
                && params.getEndYear() == null
                && params.getGender() == null
                && params.getName() == null
                && params.getNationality() == null
                && params.getWikiQID() == null;
    }
}
