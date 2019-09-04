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

    List<GeolocationEntity> findAll();
}
