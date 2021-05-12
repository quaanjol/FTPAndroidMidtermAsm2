package com.kwan.midtermasm2.api;

import com.kwan.midtermasm2.model.AccuWeatherDailyFive;
import com.kwan.midtermasm2.model.AccuWeatherHourlyTwelve;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AccuWeatherDailyFiveApi {
    String DOMAIN = "http://dataservice.accuweather.com";

    @GET("/forecasts/v1/daily/5day/353412?apikey=vF2qA4zm5oFjtl5w4uJ1umvgvJS4gM2s&language=vi-vn&metric=true")
    Call<AccuWeatherDailyFive> getAccuWeatherDailyFive();

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=vF2qA4zm5oFjtl5w4uJ1umvgvJS4gM2s&language=vi-vn&metric=true")
    Call<List<AccuWeatherHourlyTwelve>> getAccuWeatherHourlyTweleve();
}
