package com.darksky.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Current {

    @JsonProperty(value = "last_updated_epoch")
    private String lastUpdatedEpoch;
    @JsonProperty(value = "temp_c")
    private Long temCelsius;
    @JsonProperty(value = "temp_f")
    private Long temFahrenheit;
}
