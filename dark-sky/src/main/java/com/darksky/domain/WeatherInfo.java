package com.darksky.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherInfo {
    private Location location;
    private Current current;
}
