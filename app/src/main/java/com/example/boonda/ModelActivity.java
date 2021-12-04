package com.example.boonda;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelActivity implements Serializable {
    String id, askerphoto, question, date, like, name, photo, reply, title, topic;
    ArrayList<ModelComment> commentList;


    public ModelActivity() {
    }

    public ModelActivity(String id,String askerPhoto, String question, String date, String like, String name, String photo, String reply, String title, String topic, ArrayList<ModelComment> comment) {
        this.askerphoto = askerPhoto;
        this.question = question;
        this.date = date;
        this.like = like;
        this.name = name;
        this.photo = photo;
        this.reply = reply;
        this.title = title;
        this.topic = topic;
        this.commentList = comment;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAskerphoto() {
        return askerphoto;
    }

    public void setAskerphoto(String askerphoto) {
        this.askerphoto = askerphoto;
    }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<ModelComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<ModelComment> commentList) {
        this.commentList = commentList;
    }
}
