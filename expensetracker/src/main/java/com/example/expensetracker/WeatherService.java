package com.example.expensetracker;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherService(@Value("${openweather.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    public JsonNode getWeather(double lat, double lon) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", apiKey)
                .toUriString();

        return restTemplate.getForObject(url, JsonNode.class);
    }
}