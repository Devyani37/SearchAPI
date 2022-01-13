package com.devyani.searchApp.SearchApp.services;

import com.devyani.searchApp.SearchApp.dtos.ArtistSearchRequest;
import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import com.devyani.searchApp.SearchApp.models.Artist;
import com.devyani.searchApp.SearchApp.repositories.ArtistRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class ArtistServiceTests {

    @Mock
    private ArtistRepository artistRepository;

    @InjectMocks
    ArtistService artistService;

    Faker faker = new Faker();

    @Test
    public void find_artist_success() {
        //Arrange
        var searchRequest = Mockito.mock(ArtistSearchRequest.class);

        var artist = new Artist();
        artist.setArtistBio(faker.lorem().sentence());
        artist.setBeginDate(1990);
        artist.setEndDate(2000);
        artist.setConstituentId(faker.number().randomDigitNotZero());
        artist.setDisplayName(faker.lorem().word());
        artist.setGender(faker.lorem().word());
        artist.setNationality(faker.lorem().word());
        artist.setWikiQID(faker.lorem().word());
        artist.setUlan(faker.lorem().word());

        Mockito.when(artistRepository.find(searchRequest)).thenReturn(List.of(artist));

        //Act
        var result = artistService.find(searchRequest);

        //Asset
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getConstituentId()).isEqualTo(artist.getConstituentId());
        assertThat(result.get(0).getArtistBio()).isEqualTo(artist.getArtistBio());
        assertThat(result.get(0).getBeginDate()).isEqualTo(artist.getBeginDate());
        assertThat(result.get(0).getEndDate()).isEqualTo(artist.getEndDate());
        assertThat(result.get(0).getDisplayName()).isEqualTo(artist.getDisplayName());
        assertThat(result.get(0).getGender()).isEqualTo(artist.getGender());
        assertThat(result.get(0).getNationality()).isEqualTo(artist.getNationality());
        assertThat(result.get(0).getUlan()).isEqualTo(artist.getUlan());
        assertThat(result.get(0).getWikiQID()).isEqualTo(artist.getWikiQID());
    }

    @Test
    public void find_artist_no_results_exception() {
        //Arrange
        var searchRequest = Mockito.mock(ArtistSearchRequest.class);

        Mockito.when(artistRepository.find(searchRequest)).thenReturn(List.of());

        //Act
        assertThatThrownBy(() -> {
            var result = artistService.find(searchRequest);
        }).isInstanceOf(SearchException.class)
                .hasMessage("Artist Not Found")
                .extracting("code").isSameAs(HttpStatus.NOT_FOUND);
    }
}
