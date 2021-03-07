package com.darksky.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private String name;
    private String region;
    private String country;
    @JsonProperty(value = "lat")
    private Long latitude;
    @JsonProperty(value = "lon")
    private Long longitude;
    @JsonProperty(value = "tz_id")
    private String tzId;
    private String localtime;

}
