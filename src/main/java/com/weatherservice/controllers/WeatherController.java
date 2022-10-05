package com.weatherservice.controllers;

import com.weatherservice.model.Weather;
import com.weatherservice.services.WeatherService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractDocument;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@EnableAsync

public class WeatherController {
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String key = "9231094a93b7d38b7e89ff60c0d78575";
    private String unit = "metric";
//
//    @Autowired
//    private WeatherService weatherService;

    @GetMapping(value = "/weather/current")
    @CrossOrigin(origins="http://localhost:8787")
    @Cacheable("weather")
    public Weather current(@RequestParam(value="location", defaultValue = "Odessa")String location) {
        String content;
        try {

            String url = URL + location + "&units=" + unit +"&appid=" + key;
            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            content = response.toString();

        } catch (Exception e) {
            System.out.print("ERROR : " + e);
            return new Weather("Not Found", "Not Found", 0,"Not Found", "Not Found");
        }
        JSONObject root = new JSONObject(content);

        JSONObject main = root.getJSONObject("main");
        JSONObject sys = root.getJSONObject("sys");
        JSONArray wea = root.getJSONArray("weather");
        JSONObject weas = wea.getJSONObject(0);

        return new Weather(
                weas.getString("main"),
                weas.getString("description"),
                main.getInt("temp"),
                sys.getString("country"),
                root.getString("name")
        );
    }






}
