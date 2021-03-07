package com.darksky.service;

import com.darksky.domain.WeatherInfo;

public interface IWeatherApiService {
    public WeatherInfo getWeatherDetails(String location);
}
