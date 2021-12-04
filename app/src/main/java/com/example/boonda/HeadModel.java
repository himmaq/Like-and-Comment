package com.example.boonda;

public class HeadModel {
    private String ages, date, head;

    public HeadModel(){}

    public HeadModel(String ages, String date, String head){
        this.ages = ages;
        this.date = date;
        this.head = head;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
