package com.example.boonda;

public class WeightModel {
    private String date;
    private Integer ages, measure;

    public WeightModel(){}

    public WeightModel(String date, Integer ages, Integer weight) {
        this.date = date;
        this.ages = ages;
        this.measure = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAges() {
        return ages;
    }

    public void setAges(Integer ages) {
        this.ages = ages;
    }

    public Integer getMeasure() {
        return measure;
    }

    public void setMeasure(Integer measure) {
        this.measure = measure;
    }
}
