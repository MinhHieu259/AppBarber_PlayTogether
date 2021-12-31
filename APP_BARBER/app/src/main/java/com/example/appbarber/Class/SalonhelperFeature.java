package com.example.appbarber.Class;

public class SalonhelperFeature {
    int  image;
    String title, address;

    public SalonhelperFeature(int image, String title, String address) {
        this.image = image;
        this.title = title;
        this.address = address;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }
}
