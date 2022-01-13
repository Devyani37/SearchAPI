package com.devyani.searchApp.SearchApp.services;

import com.devyani.searchApp.SearchApp.dtos.ArtworkSearchRequest;
import com.devyani.searchApp.SearchApp.exceptions.SearchException;
import com.devyani.searchApp.SearchApp.models.Artwork;
import com.devyani.searchApp.SearchApp.repositories.ArtworkRepository;
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
public class ArtworkServiceTests {

    @Mock
    private ArtworkRepository artworkRepository;

    @InjectMocks
    ArtworkService artworkService;

    Faker faker = new Faker();

    @Test
    public void find_artwork_success() {
        // Arrange
        var searchRequest = Mockito.mock(ArtworkSearchRequest.class);

        var artwork = new Artwork();
        artwork.setTitle(faker.lorem().sentence());
        artwork.setArtists(List.of(faker.lorem().word()));
        artwork.setConstituentId(List.of(faker.number().randomDigitNotZero()));
        artwork.setArtistsBio(List.of(faker.lorem().word()));
        artwork.setNationality(List.of(faker.lorem().word()));
        artwork.setBeginDate(List.of(faker.number().randomDigitNotZero()));
        artwork.setEndDate(List.of(faker.number().randomDigitNotZero()));
        artwork.setGender(List.of(faker.lorem().word()));
        artwork.setArtworkDate(faker.lorem().word());
        artwork.setMedium(faker.lorem().word());
        artwork.setDimensions(faker.lorem().word());
        artwork.setCreditLine(faker.lorem().word());
        artwork.setAccessionNumber(faker.lorem().word());
        artwork.setClassification(faker.lorem().word());
        artwork.setDepartment(faker.lorem().word());
        artwork.setCataloged(faker.lorem().word());
        artwork.setUrl(faker.internet().url());
        artwork.setThumbnail(faker.internet().avatar());
        artwork.setHeight(faker.number().randomDigitNotZero());
        artwork.setWidth(faker.number().randomDigitNotZero());
        artwork.setObjectId(faker.number().randomDigitNotZero());
        artwork.setDateAcquired(faker.lorem().word());

        Mockito.when(artworkRepository.findArtworks(searchRequest)).thenReturn(List.of(artwork));

        //Act
        var result = artworkService.find(searchRequest);

        //Asset
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAccessionNumber()).isEqualTo(artwork.getAccessionNumber());
        assertThat(result.get(0).getTitle()).isEqualTo(artwork.getTitle());
        assertThat(result.get(0).getArtists()).isEqualTo(artwork.getArtists());
        assertThat(result.get(0).getConstituentId()).isEqualTo(artwork.getConstituentId());
        assertThat(result.get(0).getArtistsBio()).isEqualTo(artwork.getArtistsBio());
        assertThat(result.get(0).getNationality()).isEqualTo(artwork.getNationality());
        assertThat(result.get(0).getBeginDate()).isEqualTo(artwork.getBeginDate());
        assertThat(result.get(0).getEndDate()).isEqualTo(artwork.getEndDate());
        assertThat(result.get(0).getGender()).isEqualTo(artwork.getGender());
        assertThat(result.get(0).getArtworkDate()).isEqualTo(artwork.getArtworkDate());
        assertThat(result.get(0).getMedium()).isEqualTo(artwork.getMedium());
        assertThat(result.get(0).getDimensions()).isEqualTo(artwork.getDimensions());
        assertThat(result.get(0).getCreditLine()).isEqualTo(artwork.getCreditLine());
        assertThat(result.get(0).getClassification()).isEqualTo(artwork.getClassification());
        assertThat(result.get(0).getDepartment()).isEqualTo(artwork.getDepartment());
        assertThat(result.get(0).getCataloged()).isEqualTo(artwork.getCataloged());
        assertThat(result.get(0).getUrl()).isEqualTo(artwork.getUrl());
        assertThat(result.get(0).getThumbnail()).isEqualTo(artwork.getThumbnail());
        assertThat(result.get(0).getHeight()).isEqualTo(artwork.getHeight());
        assertThat(result.get(0).getWidth()).isEqualTo(artwork.getWidth());
        assertThat(result.get(0).getObjectId()).isEqualTo(artwork.getObjectId());
        assertThat(result.get(0).getDateAcquired()).isEqualTo(artwork.getDateAcquired());
    }

    @Test
    public void find_artwork_no_results_exception() {
        //Arrange
        var searchRequest = Mockito.mock(ArtworkSearchRequest.class);

        Mockito.when(artworkRepository.findArtworks(searchRequest)).thenReturn(List.of());

        //Act
        assertThatThrownBy(() -> {
            var result = artworkService.find(searchRequest);
        }).isInstanceOf(SearchException.class)
                .hasMessage("Artwork Not Found")
                .extracting("code").isSameAs(HttpStatus.NOT_FOUND);
    }
}
