package com.example.boonda;

class Model {
    String askerphoto, question, date, like, name, photo, reply, title, topic;

    public Model() {
    }

    public Model(String askerPhoto, String question, String date, String like, String name, String photo, String reply, String title, String topic) {
        this.askerphoto = askerPhoto;
        this.question = question;
        this.date = date;
        this.like = like;
        this.name = name;
        this.photo = photo;
        this.reply = reply;
        this.title = title;
        this.topic = topic;
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
}
