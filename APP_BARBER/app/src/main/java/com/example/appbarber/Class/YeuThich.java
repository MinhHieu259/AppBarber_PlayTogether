package com.example.appbarber.Class;

public class YeuThich {
    private int id_yeuthich;
    private int id_salon;
    private String tenSalon;
    private int imageSalon;

    public YeuThich(String tenSalon, int imageSalon) {
        this.tenSalon = tenSalon;
        this.imageSalon = imageSalon;
    }

    public int getId_yeuthich() {
        return id_yeuthich;
    }

    public void setId_yeuthich(int id_yeuthich) {
        this.id_yeuthich = id_yeuthich;
    }

    public int getId_salon() {
        return id_salon;
    }

    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }

    public String getTenSalon() {
        return tenSalon;
    }

    public void setTenSalon(String tenSalon) {
        this.tenSalon = tenSalon;
    }

    public int getImageSalon() {
        return imageSalon;
    }

    public void setImageSalon(int imageSalon) {
        this.imageSalon = imageSalon;
    }
}
