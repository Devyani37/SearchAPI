package com.devyani.searchApp.SearchApp.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Represents Artist Search Response. Ignores Null, Empty and unknown values.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ArtistSearchResponse {

    @JsonProperty("ConstituentID")
    private Integer constituentId;
    @JsonProperty("DisplayName")
    private String displayName;
    @JsonProperty("ArtistBio")
    private String artistBio;
    @JsonProperty("Nationality")
    private String nationality;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("BeginDate")
    private Integer beginDate;
    @JsonProperty("EndDate")
    private Integer endDate;
    @JsonProperty("Wiki QID")
    private String wikiQID;
    @JsonProperty("ULAN")
    private String ulan;

    public Integer getConstituentId() {
        return constituentId;
    }

    public void setConstituentId(Integer constituentId) {
        this.constituentId = constituentId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getArtistBio() {
        return artistBio;
    }

    public void setArtistBio(String artistBio) {
        this.artistBio = artistBio;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getWikiQID() {
        return wikiQID;
    }

    public void setWikiQID(String wikiQID) {
        this.wikiQID = wikiQID;
    }

    public String getUlan() {
        return ulan;
    }

    public void setUlan(String ulan) {
        this.ulan = ulan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtistSearchResponse)) return false;
        ArtistSearchResponse that = (ArtistSearchResponse) o;
        return Objects.equals(getConstituentId(), that.getConstituentId()) &&
                Objects.equals(getDisplayName(), that.getDisplayName()) &&
                Objects.equals(getArtistBio(), that.getArtistBio()) &&
                Objects.equals(getNationality(), that.getNationality()) &&
                Objects.equals(getGender(), that.getGender()) &&
                Objects.equals(getBeginDate(), that.getBeginDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                Objects.equals(getWikiQID(), that.getWikiQID()) &&
                Objects.equals(getUlan(), that.getUlan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConstituentId(), getDisplayName(), getArtistBio(), getNationality(), getGender(), getBeginDate(), getEndDate(), getWikiQID(), getUlan());
    }

    @Override
    public String toString() {
        return "ArtistSearchResponse{" +
                "constituentId=" + constituentId +
                ", displayName='" + displayName + '\'' +
                ", artistBio='" + artistBio + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", wikiQID='" + wikiQID + '\'' +
                ", ulan='" + ulan + '\'' +
                '}';
    }
}
