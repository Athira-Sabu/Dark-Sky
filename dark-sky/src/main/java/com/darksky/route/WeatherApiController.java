package com.darksky.route;

import com.darksky.domain.WeatherInfo;
import com.darksky.service.IWeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WeatherApiController {

    @Autowired
    private IWeatherApiService weatherApiService;

    @GetMapping("/getWeather")
    public ResponseEntity<WeatherInfo> getWeather(@RequestParam String location) {
        WeatherInfo weatherInfo = weatherApiService.getWeatherDetails(location);
        return new ResponseEntity<>(weatherInfo, HttpStatus.OK);
    }

}
