package com.devyani.searchApp.SearchApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Artwork Data model.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Artwork {

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
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Artist")
    private List<String> artists;
    @JsonProperty("ConstituentID")
    private List<Integer> constituentId;
    @JsonProperty("ArtistBio")
    private List<String> artistsBio;
    @JsonProperty("Nationality")
    private List<String> nationality;
    @JsonProperty("BeginDate")
    private List<Integer> beginDate;
    @JsonProperty("EndDate")
    private List<Integer> endDate;
    @JsonProperty("Gender")
    private List<String> gender;
    @JsonProperty("Date")
    private String artworkDate;
    @JsonProperty("Medium")
    private String medium;
    @JsonProperty("Dimensions")
    private String dimensions;
    @JsonProperty("CreditLine")
    private String creditLine;
    @JsonProperty("AccessionNumber")
    private String accessionNumber;
    @JsonProperty("Classification")
    private String classification;
    @JsonProperty("Department")
    private String department;
    @JsonProperty("Cataloged")
    private String cataloged;
    @JsonProperty("URL")
    private String url;
    @JsonProperty("ThumbnailURL")
    private String thumbnail;
    @JsonProperty("Height (cm)")
    private double height;
    @JsonProperty("Width (cm)")
    private double width;
    @JsonProperty("ObjectID")
    private Integer objectId;
    @JsonProperty("DateAcquired")
    private String dateAcquired;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public List<Integer> getConstituentId() {
        return constituentId;
    }

    public void setConstituentId(List<Integer> constituentId) {
        this.constituentId = constituentId;
    }

    public List<String> getArtistsBio() {
        return artistsBio;
    }

    public void setArtistsBio(List<String> artistsBio) {
        this.artistsBio = artistsBio;
    }

    public List<String> getNationality() {
        return nationality;
    }

    public void setNationality(List<String> nationality) {
        this.nationality = nationality;
    }

    public List<Integer> getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(List<Integer> beginDate) {
        this.beginDate = beginDate;
    }

    public List<Integer> getEndDate() {
        return endDate;
    }

    public void setEndDate(List<Integer> endDate) {
        this.endDate = endDate;
    }

    public List<String> getGender() {
        return gender;
    }

    public void setGender(List<String> gender) {
        this.gender = gender;
    }

    public String getArtworkDate() {
        return artworkDate;
    }

    public void setArtworkDate(String artworkDate) {
        this.artworkDate = artworkDate;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCataloged() {
        return cataloged;
    }

    public void setCataloged(String cataloged) {
        this.cataloged = cataloged;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artwork)) return false;
        Artwork artwork = (Artwork) o;
        return Double.compare(artwork.getHeight(), getHeight()) == 0 &&
                Double.compare(artwork.getWidth(), getWidth()) == 0 &&
                Objects.equals(getId(), artwork.getId()) &&
                Objects.equals(getRevision(), artwork.getRevision()) &&
                Objects.equals(getTitle(), artwork.getTitle()) &&
                Objects.equals(getArtists(), artwork.getArtists()) &&
                Objects.equals(getConstituentId(), artwork.getConstituentId()) &&
                Objects.equals(getArtistsBio(), artwork.getArtistsBio()) &&
                Objects.equals(getNationality(), artwork.getNationality()) &&
                Objects.equals(getBeginDate(), artwork.getBeginDate()) &&
                Objects.equals(getEndDate(), artwork.getEndDate()) &&
                Objects.equals(getGender(), artwork.getGender()) &&
                Objects.equals(getArtworkDate(), artwork.getArtworkDate()) &&
                Objects.equals(getMedium(), artwork.getMedium()) &&
                Objects.equals(getDimensions(), artwork.getDimensions()) &&
                Objects.equals(getCreditLine(), artwork.getCreditLine()) &&
                Objects.equals(getAccessionNumber(), artwork.getAccessionNumber()) &&
                Objects.equals(getClassification(), artwork.getClassification()) &&
                Objects.equals(getDepartment(), artwork.getDepartment()) &&
                Objects.equals(getCataloged(), artwork.getCataloged()) &&
                Objects.equals(getUrl(), artwork.getUrl()) &&
                Objects.equals(getThumbnail(), artwork.getThumbnail()) &&
                Objects.equals(getObjectId(), artwork.getObjectId()) &&
                Objects.equals(getDateAcquired(), artwork.getDateAcquired());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRevision(), getTitle(), getArtists(), getConstituentId(), getArtistsBio(), getNationality(), getBeginDate(), getEndDate(), getGender(), getArtworkDate(), getMedium(), getDimensions(), getCreditLine(), getAccessionNumber(), getClassification(), getDepartment(), getCataloged(), getUrl(), getThumbnail(), getHeight(), getWidth(), getObjectId(), getDateAcquired());
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id='" + id + '\'' +
                ", revision='" + revision + '\'' +
                ", title='" + title + '\'' +
                ", artists=" + artists +
                ", constituentId=" + constituentId +
                ", artistsBio=" + artistsBio +
                ", nationality=" + nationality +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", gender=" + gender +
                ", artworkDate='" + artworkDate + '\'' +
                ", medium='" + medium + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", creditLine='" + creditLine + '\'' +
                ", accessionNumber='" + accessionNumber + '\'' +
                ", classification='" + classification + '\'' +
                ", department='" + department + '\'' +
                ", cataloged='" + cataloged + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", objectId=" + objectId +
                ", dateAcquired='" + dateAcquired + '\'' +
                '}';
    }
}