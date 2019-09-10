package com.restapi.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeolocationDTO {

    @JsonProperty("osm_type")
    private String osmType;
    @JsonProperty("osm_id")
    private int osmId;
    @JsonProperty("lat")
    private double latitute;
    private double lon;
    @JsonProperty("display_name")
    private String displayName;
    private String query;
    @JsonProperty("address")
    private AddressDTO addressDTO;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getOsmType() {
        return osmType;
    }

    public void setOsmType(String osmType) {
        this.osmType = osmType;
    }

    public int getOsmId() {
        return osmId;
    }

    public void setOsmId(int osmId) {
        this.osmId = osmId;
    }

    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
