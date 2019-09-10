package com.restapi.example.repository;

import com.restapi.example.entity.GeolocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public interface GeolocationRepo extends JpaRepository<GeolocationEntity,Integer> {

    /**
     * Retrieves all items from database
     *
     * @return list of data entity
     */
    List<GeolocationEntity> findAll();

    /**
     * Retrieves items from database by username
     *
     * @param username name of User object
     * @return list of data entity with current username
     */
    List<GeolocationEntity> findAllByUsername(String username);

    /**
     * Retrieves items by country
     *
     * @param countryName country name of Address entity
     * @return list of data entity by input countryName parameter
     */
    List<GeolocationEntity> findAllByAddressEntity_Country(String countryName);
}
