package CST438Assign3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import CST438Assign3.domain.*;
import CST438Assign3.service.CityService;

@RestController
public class CityRestController {
    
    @Autowired
    private CityService cityService;
    
    @GetMapping("/api/cities/{city}")
    public CityInfo getWeather(@PathVariable("city") String cityName) { 
        CityInfo cityInfo = cityService.getCityInfo(cityName);
        return cityInfo; 
    }
    
}

