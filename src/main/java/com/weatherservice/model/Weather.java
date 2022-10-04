package com.weatherservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Weather {
    private String main;
    private String description;
    private float temp;
    private String country;
    private String city;
}
