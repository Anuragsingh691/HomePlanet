package com.example.appsolarar.model;

public class Data {
    private String PName,description,pid,category,date,time,image;
    public Data( String PName,String description,String pid,String category,String date,String time,String image)
    {
        this.PName = PName;
        this.description = description;
        this.pid = pid;
        category = category;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public Data()
    {

    }
    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
