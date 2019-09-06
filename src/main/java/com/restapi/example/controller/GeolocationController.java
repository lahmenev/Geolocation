package com.restapi.example.controller;

import com.restapi.example.dto.GeolocationDTO;
import com.restapi.example.entity.GeolocationEntity;
import com.restapi.example.service.GeoDataService;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
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

    @PostMapping("/location")
    public String saveDataByLocation(@ModelAttribute("geoData") GeolocationDTO geolocationDTO) throws IOException {
        double latitute = geolocationDTO.getLatitute();
        double lon = geolocationDTO.getLon();

        GeolocationDTO geoDetails = geoDataService.retrieveGeoDetails(
                "https://nominatim.openstreetmap.org/reverse?format=json&lat="+latitute+"&lon="+lon+""
        );

        geoDataService.saveData(geoDetails);

        return "redirect:/geolocation";
    }

    @PostMapping("/query")
    public String saveDataByQuery(@ModelAttribute("geoData") GeolocationDTO geolocationDTO) throws IOException {
        String query = geolocationDTO.getQuery();

        GeolocationDTO geoDetails = geoDataService.retrieveGeoDetails(
                "https://nominatim.openstreetmap.org/?format=json&addressdetails=1&q="+query+"&format=json&limit=1"
        );

        geoDataService.saveData(geoDetails);

        return "redirect:/geolocation";
    }

    @GetMapping("/putCoordinates")
    public String showCoordinatesForm(Model model) {
        model.addAttribute("geoData", new GeolocationDTO());
        return "geoForm";
    }

    @GetMapping("/putQuery")
    public String showQueryForm(Model model) {
        model.addAttribute("geoData", new GeolocationDTO());
        return "queryForm";
    }

    @GetMapping
    public String showGeoList(Model model) {
        model.addAttribute("geoList", geoDataService.getGeoList());
        return "geoList";
    }

    @GetMapping("/countrySearch")
    public String showCountrySearchForm(Model model) {
        model.addAttribute("geoData", new GeolocationDTO());
        return "countrySearchForm";
    }

    @PostMapping("/countrySearch/search")
    public String searchDataByCountry(@ModelAttribute("geoData") GeolocationDTO geolocationDTO, Model model) {
        String countryName = geolocationDTO.getQuery();

        List<GeolocationEntity> detailsByCountry = geoDataService.getDetailsByCountry(countryName);
        model.addAttribute("detailsByCountry", detailsByCountry);
        return "countryList";
    }

}
