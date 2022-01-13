package com.devyani.searchApp.SearchApp.controllers;

import com.devyani.searchApp.SearchApp.dtos.ArtworkSearchRequest;
import com.devyani.searchApp.SearchApp.dtos.ArtworkSearchResponse;
import com.devyani.searchApp.SearchApp.services.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
/**
 * API Controller for Artwork resource.
 */
@RestController
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    /**
     * Find Artwork based on input params. At least one search params must be provided.
     * @param params see {@link ArtworkSearchRequest}
     * @return List of Artwork.
     */
    @GetMapping("/artworks")
    public List<ArtworkSearchResponse> findArtworks(@Valid ArtworkSearchRequest params) {
        if (isEveryParamsNull(params)) {
            throw new IllegalArgumentException("Must have at least one fields to search");
        }

        return artworkService.find(params);
    }

    /**
     * Validate if all artwork search params are null.
     * @param params see {@link ArtworkSearchRequest}
     * @return true if all search params are null, false otherwise.
     */
    private boolean isEveryParamsNull(ArtworkSearchRequest params) {
        return params.getAccessionNumber() == null
                && params.getArtist() == null
                && params.getArtistsBio() == null
                && params.getBeginDate() == null
                && params.getClassification() == null
                && params.getConstituentId() == null
                && params.getCreditLine() == null
                && params.getEndDate() == null
                && params.getGender() == null
                && params.getMedium() == null
                && params.getNationality() == null
                && params.getObjectId() == null
                && params.getTitle() == null;
    }
}
