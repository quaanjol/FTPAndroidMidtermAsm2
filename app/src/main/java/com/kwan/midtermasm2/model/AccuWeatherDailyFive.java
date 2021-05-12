package com.kwan.midtermasm2.model;

import java.util.List;

public class AccuWeatherDailyFive {
    private Headline Headline;
    private List<DailyForecast> DailyForecasts;

    public AccuWeatherDailyFive(com.kwan.midtermasm2.model.Headline headline, List<DailyForecast> dailyForecasts) {
        Headline = headline;
        DailyForecasts = dailyForecasts;
    }

    public com.kwan.midtermasm2.model.Headline getHeadline() {
        return Headline;
    }

    public void setHeadline(com.kwan.midtermasm2.model.Headline headline) {
        Headline = headline;
    }

    public List<DailyForecast> getDailyForecasts() {
        return DailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        DailyForecasts = dailyForecasts;
    }
}
