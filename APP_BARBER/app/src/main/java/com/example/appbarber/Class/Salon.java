package com.example.appbarber.Class;

public class Salon {
    public String name, address;
    public int image;
    public float rating;

    public Salon(String name, String address, int image, float rating) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }
}
