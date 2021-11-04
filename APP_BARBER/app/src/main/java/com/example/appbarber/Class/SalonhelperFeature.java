package com.example.appbarber.Class;

public class SalonhelperClasss {
    int  image;
    String title, address;

    public SalonhelperClasss(int image, String title, String address) {
        this.image = image;
        this.title = title;
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
