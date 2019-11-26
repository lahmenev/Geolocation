package com.restapi.example.controller;

import com.restapi.example.dto.GeolocationDTO;
import com.restapi.example.entity.GeolocationEntity;
import com.restapi.example.service.GeoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Controller
@RequestMapping("/geolocation")
public class GeolocationController {

    @Autowired
    GeoDataService geoDataService;

    /**
     * Saves geolocation details by coordinates
     *
     * @param geolocationDTO input parameter of geolocation details
     * @param principal input parameter of current Principal
     * @return view representation
     * @throws IOException
     */
    @PostMapping("/location")
    public String saveDataByLocation(@ModelAttribute("geoData") GeolocationDTO geolocationDTO, Principal principal) throws IOException {
        String username = principal.getName();
        double latitute = geolocationDTO.getLatitute();
        double lon = geolocationDTO.getLon();

        GeolocationDTO geoDetails = geoDataService.convertToObject(
                "https://nominatim.openstreetmap.org/reverse?format=json&lat="+latitute+"&lon="+lon+""
        );

        geoDataService.saveData(geoDetails, username);

        return "redirect:/geolocation";
    }

    /**
     * Saves geolocation details by query
     *
     * @param query input parameter
     * @param principal input parameter of current Principal
     * @return view representation
     * @throws IOException
     */
    @PostMapping("/query")
    public String saveDataByQuery(@RequestParam(value = "query", required = false) String query, Principal principal) throws IOException {
        String username = principal.getName();

        GeolocationDTO geoDetails = geoDataService.convertToObject(
                "https://nominatim.openstreetmap.org/?format=json&addressdetails=1&q="+query+"&format=json&limit=1"
        );

        geoDataService.saveData(geoDetails, username);

        return "redirect:/geolocation";
    }

    /**
     * Shows form for adding coordinates
     * asda
     *
     * @param model Model for storing object
     * @return view representation
     */
    @GetMapping("/putCoordinates")
    public String showCoordinatesForm(Model model) {
        model.addAttribute("geoData", new GeolocationDTO());
        return "geoForm";
    }

    /**
     * Shows view of geolocation log
     *
     * @param model Model for storing object
     * @param principal current Principal
     * @return
     */
    @GetMapping
    public String showGeoList(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("geoList", geoDataService.getGeoList(username));
        return "geoList";
    }

    /**
     * Shows form for searching log by country
     *
     * @param model Model for storing object
     * @return view representation
     */
    @GetMapping("/countrySearch")
    public String showCountrySearchForm(Model model) {
        model.addAttribute("geoData", new GeolocationDTO());
        return "countrySearchForm";
    }

    /**
     * Retrieve log by country
     *
     * @param geolocationDTO input parameter of geolocation details
     * @param model Model for storing object
     * @return view representation
     */
    @PostMapping("/countrySearch/search")
    public String searchDataByCountry(@ModelAttribute("geoData") GeolocationDTO geolocationDTO, Model model) {
        String countryName = geolocationDTO.getQuery();

        List<GeolocationEntity> detailsByCountry = geoDataService.getDetailsByCountry(countryName);
        model.addAttribute("detailsByCountry", detailsByCountry);
        return "countryList";
    }
}
