package com.weatherService.weatherService.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @RequestMapping(method = RequestMethod.GET, value = "/weatherByCity/{city}")
    public @ResponseBody Object getWeatherByCity(@PathVariable String city) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> response = restTemplate.getForEntity(
                "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                        "&APPID=API_HERE",
                Object.class);

        return response;
    }

}