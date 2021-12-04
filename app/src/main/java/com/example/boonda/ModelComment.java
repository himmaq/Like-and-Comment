package com.example.boonda;

import java.io.Serializable;

public class ModelComment implements Serializable {
    String date, comment;
    String id;

    public ModelComment(){}

    public ModelComment( String date, String comment, String id){
this.id = id;
        this.date = date;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
