package ar.utn.ba.ddsi.mailing.models.dto.external.weatherapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    private Location location;
    private Current current;
} 