package com.devyani.searchApp.SearchApp.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Represents Artwork Search Request Parameters. All these parameters comes as query params.
 */
public class ArtworkSearchRequest {

    private static final String MUST_NOT_BLANK_REGEX = "^(?!\\s*$).+";

    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String title;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String artist;
    @Min(1)
    private Integer constituentId;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String artistsBio;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String nationality;
    @Min(0)
    private Integer beginDate;
    @Min(0)
    private Integer endDate;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String gender;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String medium;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String creditLine;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String accessionNumber;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String classification;
    @Min(1)
    private Integer objectId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getConstituentId() {
        return constituentId;
    }

    public void setConstituentId(Integer constituentId) {
        this.constituentId = constituentId;
    }

    public String getArtistsBio() {
        return artistsBio;
    }

    public void setArtistsBio(String artistsBio) {
        this.artistsBio = artistsBio;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtworkSearchRequest)) return false;
        ArtworkSearchRequest that = (ArtworkSearchRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getArtist(), that.getArtist()) &&
                Objects.equals(getConstituentId(), that.getConstituentId()) &&
                Objects.equals(getArtistsBio(), that.getArtistsBio()) &&
                Objects.equals(getNationality(), that.getNationality()) &&
                Objects.equals(getBeginDate(), that.getBeginDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                Objects.equals(getGender(), that.getGender()) &&
                Objects.equals(getMedium(), that.getMedium()) &&
                Objects.equals(getCreditLine(), that.getCreditLine()) &&
                Objects.equals(getAccessionNumber(), that.getAccessionNumber()) &&
                Objects.equals(getClassification(), that.getClassification()) &&
                Objects.equals(getObjectId(), that.getObjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getArtist(), getConstituentId(), getArtistsBio(), getNationality(), getBeginDate(), getEndDate(), getGender(), getMedium(), getCreditLine(), getAccessionNumber(), getClassification(), getObjectId());
    }

    @Override
    public String toString() {
        return "ArtworkSearchRequest{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", constituentId=" + constituentId +
                ", artistsBio='" + artistsBio + '\'' +
                ", nationality='" + nationality + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", gender='" + gender + '\'' +
                ", medium='" + medium + '\'' +
                ", creditLine='" + creditLine + '\'' +
                ", accessionNumber='" + accessionNumber + '\'' +
                ", classification='" + classification + '\'' +
                ", objectId=" + objectId +
                '}';
    }
}
