package com.devyani.searchApp.SearchApp.dtos;


import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Represents Artist Search Request Parameters. All these parameters comes as query params.
 */
public class ArtistSearchRequest {

    private static final String MUST_NOT_BLANK_REGEX = "^(?!\\s*$).+";

    @Min(1)
    private Integer id;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String name;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String nationality;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String gender;
    @Min(0)
    private Integer beginYear;
    @Min(0)
    private Integer endYear;
    @Pattern(regexp = MUST_NOT_BLANK_REGEX, message = "Must not be blank")
    private String wikiQID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(Integer beginYear) {
        this.beginYear = beginYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public String getWikiQID() {
        return wikiQID;
    }

    public void setWikiQID(String wikiQID) {
        this.wikiQID = wikiQID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtistSearchRequest)) return false;
        ArtistSearchRequest that = (ArtistSearchRequest) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getNationality(), that.getNationality()) &&
                Objects.equals(getGender(), that.getGender()) &&
                Objects.equals(getBeginYear(), that.getBeginYear()) &&
                Objects.equals(getEndYear(), that.getEndYear()) &&
                Objects.equals(getWikiQID(), that.getWikiQID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNationality(), getGender(), getBeginYear(), getEndYear(), getWikiQID());
    }

    @Override
    public String toString() {
        return "SearchArtistRequest{" +
                "id=" + id +
                ", displayName='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", beginDate=" + beginYear +
                ", endDate=" + endYear +
                ", wikiQID='" + wikiQID + '\'' +
                '}';
    }
}
