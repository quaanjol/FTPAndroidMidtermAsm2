package com.kwan.midtermasm2.model;

public class DayNight {
    private int Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;

    public DayNight(int icon, String iconPhrase, boolean hasPrecipitation) {
        Icon = icon;
        IconPhrase = iconPhrase;
        HasPrecipitation = hasPrecipitation;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }
}
