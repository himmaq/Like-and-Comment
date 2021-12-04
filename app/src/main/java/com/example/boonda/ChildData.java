package com.example.boonda;

class ChildData {
    String birthday, childName, gender, head, height,  photoProfile, premature, weight;

    public ChildData(){}

    public ChildData(String birthday, String childName, String gender, String head, String height, String photoProfile, String premature, String weight) {
        this.birthday = birthday;
        this.childName = childName;
        this.gender = gender;
        this.head = head;
        this.height = height;
        this.photoProfile = photoProfile;
        this.premature = premature;
        this.weight = weight;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getPremature() {
        return premature;
    }

    public void setPremature(String premature) {
        this.premature = premature;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
