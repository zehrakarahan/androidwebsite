package com.example.myapplication;

public class Teacher {
    private String name;
    private String imageUrl;
    private Double Fiyat;
    private String key;
    private String description;
    private int position;

    public Teacher() {
    }

    public Teacher(int position) {
        this.position = position;
    }

    public Teacher(String name, String imageUrl, String description,Double fiyat) {
        if(name.trim().equals(""))
        {
            name="No name";
        }
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.Fiyat=fiyat;
    }

    public Double getFiyat() {
        return Fiyat;
    }

    public void setFiyat(Double fiyat) {
        Fiyat = fiyat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
