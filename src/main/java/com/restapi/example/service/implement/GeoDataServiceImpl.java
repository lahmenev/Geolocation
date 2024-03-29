package com.restapi.example.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.example.dto.GeolocationDTO;
import com.restapi.example.entity.AddressEntity;
import com.restapi.example.entity.GeolocationEntity;
import com.restapi.example.repository.GeolocationRepo;
import com.restapi.example.service.GeoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Service
public class GeoDataServiceImpl implements GeoDataService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GeolocationRepo geoRepo;

    /**
     * Retrieves data from Json and converts it to GeolocationDTO object
     *
     * @param url input url of API with Json data
     * @return GeolocationDTO object
     * @throws IOException
     */
    @Override
    public GeolocationDTO convertToObject(String url) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "rest_api_example");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, entity, String.class);

        String jsonData = responseEntity.getBody();

        if (jsonData.startsWith("[")) {
            jsonData = jsonData.substring(1, jsonData.length() - 1);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonData, GeolocationDTO.class);
    }

    /**
     * Saves Geolocation data to database with specified user
     *
     * @param geolocationDTO object with data from API
     * @param username specified name of user
     */
    @Override
    public void saveData(GeolocationDTO geolocationDTO, String username) {
        AddressEntity addressEntity = new AddressEntity();
        GeolocationEntity geolocationEntity = new GeolocationEntity();

        addressEntity.setCountry(geolocationDTO.getAddressDTO().getCountry());

        geolocationEntity.setAddressEntity(addressEntity);
        geolocationEntity.setDisplayName(geolocationDTO.getDisplayName());
        geolocationEntity.setOsmId(geolocationDTO.getOsmId());
        geolocationEntity.setOsmType(geolocationDTO.getOsmType());
        geolocationEntity.setLatitute(geolocationDTO.getLatitute());
        geolocationEntity.setLon(geolocationDTO.getLon());
        geolocationEntity.setUsername(username);
        geoRepo.save(geolocationEntity);
    }

    /**
     * Retrieves data from database
     *
     * @param username specified name of user
     * @return list of GeolocationEntity data
     */
    @Override
    public List<GeolocationEntity> getGeoList(String username) {
        return geoRepo.findAllByUsername(username);
    }

    /**
     * Retrieves data by country
     *
     * @param countryName specified name of country
     * @return list of GeolocationEntity data
     */
    @Override
    public List<GeolocationEntity> getDetailsByCountry(String countryName) {
        return geoRepo.findAllByAddressEntity_Country(countryName);
    }
}
