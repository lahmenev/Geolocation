package com.restapi.example.controller;

import com.restapi.example.dto.GeolocationDTO;
import com.restapi.example.entity.AddressEntity;
import com.restapi.example.entity.GeolocationEntity;
import com.restapi.example.service.GeoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

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

    @PostMapping
    public String saveDataByLocation(@ModelAttribute("geoData") GeolocationDTO geolocationDTO) throws IOException {
        double latitute = geolocationDTO.getLatitute();
        double lon = geolocationDTO.getLon();

        GeolocationDTO jsonData = geoDataService.retrieveGeoDetails(
                "https://nominatim.openstreetmap.org/reverse?format=json&lat="+latitute+"&lon="+lon+""
        );

        geoDataService.saveData(jsonData);

        return "redirect:/geolocation";
    }

    //public String saveDataByQuery()

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
}
