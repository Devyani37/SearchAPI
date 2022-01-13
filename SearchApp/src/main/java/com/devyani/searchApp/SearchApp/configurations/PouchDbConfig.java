package com.devyani.searchApp.SearchApp.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration for Pouch DB. Gets data from application.yml
 */
@Component
@ConfigurationProperties(prefix = "pouch-db")
public class PouchDbConfig {
    /**
     * Database host name.
     */
    private String host;
    /**
     * Artist database name.
     */
    private String artistdb;
    /**
     * Artwork database name.
     */
    private String artworkdb;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getArtistdb() {
        return artistdb;
    }

    public void setArtistdb(String artistdb) {
        this.artistdb = artistdb;
    }

    public String getArtworkdb() {
        return artworkdb;
    }

    public void setArtworkdb(String artworkdb) {
        this.artworkdb = artworkdb;
    }
}
