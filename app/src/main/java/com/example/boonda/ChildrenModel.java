package com.example.boonda;

public class ChildrenModel {

    String childName, photoProfile;

    public ChildrenModel(){}

    public ChildrenModel(String childName, String photoProfile) {

        this.childName = childName;
        this.photoProfile = photoProfile;
    }


    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }
}
