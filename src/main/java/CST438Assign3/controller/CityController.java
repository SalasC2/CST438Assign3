package CST438Assign3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import CST438Assign3.service.CityService;
import CST438Assign3.domain.CityInfo;

@Controller
public class CityController {
    
    @Autowired
    private CityService cityService;
    
    @GetMapping("/cities/{city}")
    public String getCityInfo(@PathVariable("city") String cityName, Model model) { 
        // City Service class returns a city info object. 
        CityInfo cityInfo = cityService.getCityInfo(cityName);
        model.addAttribute("cityInfo", cityInfo);
        return "city_info";
  
    }
    
    @PostMapping("/cities/reservation")
    public String createReservation(
            @RequestParam("city") String cityName,
            @RequestParam("level") String level,
            @RequestParam("email") String email,
            Model model) {
        model.addAttribute("city", cityName);
        model.addAttribute("level", level);
        model.addAttribute("email", email);
        cityService.requestReservation(cityName, level, email);
        return "request_reservation";
    } 
}

