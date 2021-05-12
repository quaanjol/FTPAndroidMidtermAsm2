package com.kwan.midtermasm2.model;

import java.util.List;

public class DailyForecast {
    private String Date;
    private int EpochDate;
    private Temperature Temperature;
    private DayNight Day;
    private DayNight Night;
    private List<String> Sources;
    private String MobileLink;
    private String Link;

    public DailyForecast(String date, int epochDate, com.kwan.midtermasm2.model.Temperature temperature, DayNight day, DayNight night, List<String> sources, String mobileLink, String link) {
        Date = date;
        EpochDate = epochDate;
        Temperature = temperature;
        Day = day;
        Night = night;
        Sources = sources;
        MobileLink = mobileLink;
        Link = link;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getEpochDate() {
        return EpochDate;
    }

    public void setEpochDate(int epochDate) {
        EpochDate = epochDate;
    }

    public com.kwan.midtermasm2.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.kwan.midtermasm2.model.Temperature temperature) {
        Temperature = temperature;
    }

    public DayNight getDay() {
        return Day;
    }

    public void setDay(DayNight day) {
        Day = day;
    }

    public DayNight getNight() {
        return Night;
    }

    public void setNight(DayNight night) {
        Night = night;
    }

    public List<String> getSources() {
        return Sources;
    }

    public void setSources(List<String> sources) {
        Sources = sources;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
