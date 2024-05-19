package com.jayani.lostandfoundapp;

public class itemModel {

    int id;
    int postType;
    String name;
    String phone;
    String description;
    String date;
    String location;


    public itemModel(int postType,String name,String phone,String description,String date,String location){
        this.postType=postType;
        this.name=name;
        this.phone=phone;
        this.description=description;
        this.date=date;
        this.location=location;
    }

    public itemModel(int id,int postType,String name,String phone,String description,String date,String location){
        this.id=id;
        this.postType=postType;
        this.name=name;
        this.phone=phone;
        this.description=description;
        this.date=date;
        this.location=location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
