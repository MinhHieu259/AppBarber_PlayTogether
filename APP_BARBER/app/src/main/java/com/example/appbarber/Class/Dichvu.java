package com.example.appbarber.Class;

public class Dichvu {
    int image;
    String tendv, gia, tensalon;

    public Dichvu(int image, String tendv, String gia, String tensalon) {
        this.image = image;
        this.tendv = tendv;
        this.gia = gia;
        this.tensalon = tensalon;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public void setTensalon(String tensalon) {
        this.tensalon = tensalon;
    }

    public int getImage() {
        return image;
    }

    public String getTendv() {
        return tendv;
    }

    public String getGia() {
        return gia;
    }

    public String getTensalon() {
        return tensalon;
    }
}
