package com.restapi.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
