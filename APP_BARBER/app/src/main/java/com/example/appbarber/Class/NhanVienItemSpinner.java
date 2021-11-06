package com.example.appbarber.Class;

public class NhanVienItemSpinner {
    private String tenNhanVien, chucVu;

    public NhanVienItemSpinner(String tenNhanVien, String chucVu) {
        this.tenNhanVien = tenNhanVien;
        this.chucVu = chucVu;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getChucVu() {
        return chucVu;
    }
}
