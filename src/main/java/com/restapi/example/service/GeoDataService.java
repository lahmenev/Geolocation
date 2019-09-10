package com.restapi.example.service;

import com.restapi.example.dto.GeolocationDTO;
import com.restapi.example.entity.GeolocationEntity;
import java.io.IOException;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public interface GeoDataService {

    /**
     * Retrieves data from Json and converts it to GeolocationDTO object
     *
     * @param url input url of API with Json data
     * @return GeolocationDTO object
     * @throws IOException
     */
    GeolocationDTO convertToObject(String url) throws IOException;

    /**
     * Saves Geolocation data to database with specified user
     *
     * @param geolocationDTO object with data from API
     * @param username specified name of user
     */
    void saveData(GeolocationDTO geolocationDTO, String username);

    /**
     * Retrieves data from database
     *
     * @param username specified name of user
     * @return list of GeolocationEntity data
     */
    List<GeolocationEntity> getGeoList(String username);

    /**
     * Retrieves data by country
     *
     * @param countryName specified name of country
     * @return list of GeolocationEntity data
     */
    List<GeolocationEntity> getDetailsByCountry(String countryName);
}
