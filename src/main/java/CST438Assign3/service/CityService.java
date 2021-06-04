package CST438Assign3.service;

import java.util.List;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CST438Assign3.domain.*;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private WeatherService weatherService;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private FanoutExchange fanout;

    public void requestReservation(
                    String cityName,
                    String level,
                    String email) {
            String msg = "{\";cityName\": \"" + cityName +
                    "\" \"level\": \"" + level +
                    "\" \"email\" \"" + email+"\"}";
            System.out.println("Sending message:" + msg);
            rabbitTemplate.convertSendAndReceive(fanout.getName(), "", msg);
       
    }
    
    public CityInfo getCityInfo(String cityName) { 
        List<City> cities = cityRepository.findByName(cityName);
        if ( cities.size()==0) {
            return null;
            
        } else {
            City city= cities.get(0);
            // get current weather
            TimeAndTemp cityWeather = weatherService.getTimeAndTemp(cityName);
            Country country = countryRepository.findByCode(city.getCountry().getCode());

            // convert temp from degrees Kelvin to degrees Fahrenheit
            double tempF = Math.round((cityWeather.temp - 273.15) * 9.0/5.0 + 32.0);

            return new CityInfo(city.getID(), city.getName(), 
                        city.getDistrict(), country.getName(), 
                        country.getCode(),city.getPopulation(), tempF);
        }
    }
    

}
