//package com.weatherservice.services;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.weatherservice.model.Weather;
//import com.weatherservice.model.WeatherResponse;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//@Service
//public class WeatherServiceImpl implements WeatherService{
//
//  //  private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
//
//    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
//    private String key = "9231094a93b7d38b7e89ff60c0d78575";
//    private String unit = "metric";
//
////   @GetMapping("/weather/current")
////    @CrossOrigin(origins="http://localhost:8787")
//    public Weather current(@RequestParam(value="location", defaultValue = "Odessa")String location) {
//        String content;
//        try {
//
//            String url = URL + location + "&units=" + unit +"&appid=" + key;
//            URL obj = new URL(url);
//
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//
//            in.close();
//            content = response.toString();
//
//        } catch (Exception e) {
//            System.out.print("ERROR : " + e);
//            return new Weather("Not Found", "Not Found", 0,"Not Found", "Not Found");
//        }
//        JSONObject root = new JSONObject(content);
//
//        JSONObject main = root.getJSONObject("main");
//        JSONObject sys = root.getJSONObject("sys");
//        JSONArray wea = root.getJSONArray("weather");
//        JSONObject weas = wea.getJSONObject(0);
//
//        return new Weather(
//                weas.getString("main"),
//                weas.getString("description"),
//                main.getInt("temp"),
//                sys.getString("country"),
//                root.getString("name")
//        );
//    }
//
//
//
////    private String cityName;
////    String unit;
////    private String API = "9231094a93b7d38b7e89ff60c0d78575";
////
////    public JSONObject getWeather () {
////        OkHttpClient client = new OkHttpClient();
////        Request request = new Request.Builder()
////                .url("https://api.openweathermap.org/data/2.5/weather?q="+getCityName()+"&units="+getUnit() +"&appid="+API+"")
////                .build();
////        try {
////            Response response = client.newCall(request).execute();
////            return new JSONObject(response.body().string());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
////
////    public JSONArray returnWeatherArray() {
////        JSONArray weatherArray = getWeather().getJSONArray("weather");
////        return weatherArray;
////    }
////
////    public JSONObject returnMain() {
////        JSONObject main = getWeather().getJSONObject("main");
////        return main;
////    }
////
////    public JSONObject returnWind() {
////        JSONObject wind = getWeather().getJSONObject("wind");
////        return wind;
////    }
////
////    public JSONObject returnSys() {
////        JSONObject sys = getWeather().getJSONObject("sys");
////        return sys;
////    }
////
////    public String getCityName() {
////        return cityName;
////    }
////
////    public void setCityName(String cityName) {
////        this.cityName = cityName;
////    }
////
////    public String getUnit() {
////        return unit;
////    }
////
////    public void setUnit(String unit) {
////        this.unit = unit;
////    }
//}
