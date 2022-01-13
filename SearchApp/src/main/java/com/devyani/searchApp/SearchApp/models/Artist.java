package com.devyani.searchApp.SearchApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Artist data model.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Artist {

    /**
     * This value will be ignored during serialization.
     */
    @JsonProperty(value = "_id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;
    /**
     * This value will be ignored during serialization.
     */
    @JsonProperty(value = "_rev", access = JsonProperty.Access.WRITE_ONLY)
    private String revision;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

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
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return getId().equals(artist.getId()) &&
                getRevision().equals(artist.getRevision()) &&
                Objects.equals(getConstituentId(), artist.getConstituentId()) &&
                Objects.equals(getDisplayName(), artist.getDisplayName()) &&
                Objects.equals(getArtistBio(), artist.getArtistBio()) &&
                Objects.equals(getNationality(), artist.getNationality()) &&
                Objects.equals(getGender(), artist.getGender()) &&
                Objects.equals(getBeginDate(), artist.getBeginDate()) &&
                Objects.equals(getEndDate(), artist.getEndDate()) &&
                Objects.equals(getWikiQID(), artist.getWikiQID()) &&
                Objects.equals(getUlan(), artist.getUlan());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRevision(), getConstituentId(), getDisplayName(), getArtistBio(), getNationality(), getGender(), getBeginDate(), getEndDate(), getWikiQID(), getUlan());
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", revision='" + revision + '\'' +
                ", constituentId=" + constituentId +
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
