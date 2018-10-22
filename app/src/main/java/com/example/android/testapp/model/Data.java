package com.example.android.testapp.model;

public class Data {

    private String title;
    private String image;
    private String price;

    public Data(String title, String price){
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
