package com.weatherservice.services;

import com.weatherservice.model.Weather;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface WeatherService {
   // WeatherResponse getDataByCityName(String cityName);
   Weather current(String location);


}
