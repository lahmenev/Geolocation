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

    GeolocationDTO retrieveGeoDetails(String url) throws IOException;

    void saveData(GeolocationDTO geolocationDTO);

    List<GeolocationEntity> getGeoList();

    List<GeolocationEntity> getDetailsByCountry(String countryName);
}
