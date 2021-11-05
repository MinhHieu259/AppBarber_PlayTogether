package com.example.appbarber.Class;

public class DichvuItemSpinner {
    private String tenDichvu;
    private int thoigian;
    private int gia;

    public DichvuItemSpinner(String tenDichvu, int thoigian, int gia) {
        this.tenDichvu = tenDichvu;
        this.thoigian = thoigian;
        this.gia = gia;
    }

    public String getTenDichvu() {
        return tenDichvu;
    }

    public int getThoigian() {
        return thoigian;
    }

    public int getGia() {
        return gia;
    }
}
