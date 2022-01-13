package com.devyani.searchApp.SearchApp.services;

import com.devyani.searchApp.SearchApp.dtos.ArtworkSearchRequest;
import com.devyani.searchApp.SearchApp.dtos.ArtworkSearchResponse;
import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import com.devyani.searchApp.SearchApp.models.Artwork;
import com.devyani.searchApp.SearchApp.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepository;

    /**
     * Search artwork as per search request. Map database response to Dto.
     * Throws SearchException with NOT_FOUND code if no artwork is found.
     * @param request see {@link ArtworkSearchRequest}
     * @return List of {@link ArtworkSearchResponse}.
     */
    public List<ArtworkSearchResponse> find(ArtworkSearchRequest request) {

        List<Artwork> artworkList = artworkRepository.findArtworks(request);

        if (artworkList.isEmpty()) {
            throw new SearchException(HttpStatus.NOT_FOUND, "Artwork Not Found");
        }

        return artworkList.stream()
                .map(artwork -> {

                    ArtworkSearchResponse artworkSearchResponse = new ArtworkSearchResponse();

                    artworkSearchResponse.setTitle(artwork.getTitle());
                    artworkSearchResponse.setArtists(artwork.getArtists());
                    artworkSearchResponse.setConstituentId(artwork.getConstituentId());
                    artworkSearchResponse.setArtistsBio(artwork.getArtistsBio());
                    artworkSearchResponse.setNationality(artwork.getNationality());
                    artworkSearchResponse.setBeginDate(artwork.getBeginDate());
                    artworkSearchResponse.setEndDate(artwork.getEndDate());
                    artworkSearchResponse.setGender(artwork.getGender());
                    artworkSearchResponse.setArtworkDate(artwork.getArtworkDate());
                    artworkSearchResponse.setMedium(artwork.getMedium());
                    artworkSearchResponse.setDimensions(artwork.getDimensions());
                    artworkSearchResponse.setCreditLine(artwork.getCreditLine());
                    artworkSearchResponse.setAccessionNumber(artwork.getAccessionNumber());
                    artworkSearchResponse.setClassification(artwork.getClassification());
                    artworkSearchResponse.setDepartment(artwork.getDepartment());
                    artworkSearchResponse.setCataloged(artwork.getCataloged());
                    artworkSearchResponse.setUrl(artwork.getUrl());
                    artworkSearchResponse.setThumbnail(artwork.getThumbnail());
                    artworkSearchResponse.setHeight(artwork.getHeight());
                    artworkSearchResponse.setWidth(artwork.getWidth());
                    artworkSearchResponse.setObjectId(artwork.getObjectId());
                    artworkSearchResponse.setDateAcquired(artwork.getDateAcquired());

                    return artworkSearchResponse;

                }).collect(Collectors.toList());

    }
}
