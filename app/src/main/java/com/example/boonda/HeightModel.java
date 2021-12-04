package com.example.boonda;

public class HeightModel {
    private String ages, date, height;

    public HeightModel(){}

    public HeightModel(String ages, String date, String height){
        this.ages = ages;
        this.date = date;
        this.height = height;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
