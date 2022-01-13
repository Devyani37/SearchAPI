package com.devyani.searchApp.SearchApp.services;

import com.devyani.searchApp.SearchApp.dtos.ArtistSearchRequest;
import com.devyani.searchApp.SearchApp.dtos.ArtistSearchResponse;
import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import com.devyani.searchApp.SearchApp.models.Artist;
import com.devyani.searchApp.SearchApp.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    /**
     * Search artist as per search request. Map database response to Dto.
     * Throws SearchException with NOT_FOUND code if no artist is found.
     * @param request see {@link ArtistSearchRequest}
     * @return List of {@link ArtistSearchResponse}.
     */
    public List<ArtistSearchResponse> find(ArtistSearchRequest request) {

        List<Artist> artistList = artistRepository.find(request);

        if (artistList.isEmpty()) {
            throw new SearchException(HttpStatus.NOT_FOUND, "Artist Not Found");
        }

        return artistList.stream()
                .map(artist -> {

                    ArtistSearchResponse artistSearchResponse = new ArtistSearchResponse();
                    artistSearchResponse.setConstituentId(artist.getConstituentId());
                    artistSearchResponse.setDisplayName(artist.getDisplayName());
                    artistSearchResponse.setNationality(artist.getNationality());
                    artistSearchResponse.setArtistBio(artist.getArtistBio());
                    artistSearchResponse.setBeginDate(artist.getBeginDate());
                    artistSearchResponse.setEndDate(artist.getEndDate());
                    artistSearchResponse.setWikiQID(artist.getWikiQID());
                    artistSearchResponse.setUlan(artist.getUlan());
                    artistSearchResponse.setGender(artist.getGender());

                    return artistSearchResponse;

                }).collect(Collectors.toList());

    }
}
