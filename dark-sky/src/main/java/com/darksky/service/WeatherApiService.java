package com.darksky.service;

import com.darksky.domain.WeatherInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class WeatherApiService implements IWeatherApiService {

    @Value("${api.key}")
    private String apiKey;
    @Value("${weather.api.base.url}")
    private String weatherApiBaseUrl;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;

   public WeatherInfo getWeatherDetails(String location) {

       UriComponentsBuilder builder = UriComponentsBuilder
               .fromUriString(weatherApiBaseUrl)
               // Add query parameter
               .queryParam("q", location)
               .queryParam("aqi", "no")
               .queryParam("key", apiKey);
    String result = restTemplate.getForObject(builder.toUriString(), String.class);
       WeatherInfo weatherInfo = null;
       if(result != null) {
           try {
               weatherInfo = mapper.readValue(result, WeatherInfo.class);
           } catch (JsonProcessingException e) {
               log.error(e.getMessage());
           }
       }
       return weatherInfo;
   }
}
