package com.kwan.midtermasm2.model;

public class Headline {
    private String EffectiveDate;
    private int EffectiveEpochDate;
    private int Severity;
    private String Text;
    private String Category;
    private String EndDate;
    private int EndEpochDate;
    private String MobileLink;
    private String Link;

    public Headline(String effectiveDate, int effectiveEpochDate, int severity, String text, String category, String endDate, int endEpochDate, String mobileLink, String link) {
        EffectiveDate = effectiveDate;
        EffectiveEpochDate = effectiveEpochDate;
        Severity = severity;
        Text = text;
        Category = category;
        EndDate = endDate;
        EndEpochDate = endEpochDate;
        MobileLink = mobileLink;
        Link = link;
    }

    public String getEffectiveDate() {
        return EffectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    public int getEffectiveEpochDate() {
        return EffectiveEpochDate;
    }

    public void setEffectiveEpochDate(int effectiveEpochDate) {
        EffectiveEpochDate = effectiveEpochDate;
    }

    public int getSeverity() {
        return Severity;
    }

    public void setSeverity(int severity) {
        Severity = severity;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public int getEndEpochDate() {
        return EndEpochDate;
    }

    public void setEndEpochDate(int endEpochDate) {
        EndEpochDate = endEpochDate;
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
