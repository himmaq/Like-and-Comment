package com.example.boonda;

public class ChartModel {
    int ages, measure;

    public ChartModel(){}

    public ChartModel(int age, int measure) {
        this.ages = age;
        this.measure = measure;
    }

    public int getAges() {
        return ages;
    }

    public int getMeasure() {
        return measure;
    }
}
