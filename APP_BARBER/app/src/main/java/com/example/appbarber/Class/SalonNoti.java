package com.example.appbarber.Class;

public class SalonNoti {
    private int hinhAnh;
    private String nhanVienCatToc;
    private String tenSalon;
    private String thoiGian;
    private String diaChi;
    private String dichVu;
    private double phiCatToc;
    private String thoiGianDuKienDichVu;
    private int trangThai;

    public SalonNoti(int hinhAnh, String nhanVienCatToc, String tenSalon, String thoiGian, String diaChi, String dichVu, double phiCatToc, String thoiGianDuKienDichVu, int trangThai) {
        this.hinhAnh = hinhAnh;
        this.nhanVienCatToc = nhanVienCatToc;
        this.tenSalon = tenSalon;
        this.thoiGian = thoiGian;
        this.diaChi = diaChi;
        this.dichVu = dichVu;
        this.phiCatToc = phiCatToc;
        this.thoiGianDuKienDichVu = thoiGianDuKienDichVu;
        this.trangThai = trangThai;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNhanVienCatToc() {
        return nhanVienCatToc;
    }

    public void setNhanVienCatToc(String nhanVienCatToc) {
        this.nhanVienCatToc = nhanVienCatToc;
    }

    public String getTenSalon() {
        return tenSalon;
    }

    public void setTenSalon(String tenSalon) {
        this.tenSalon = tenSalon;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public double getPhiCatToc() {
        return phiCatToc;
    }

    public void setPhiCatToc(double phiCatToc) {
        this.phiCatToc = phiCatToc;
    }

    public String getThoiGianDuKienDichVu() {
        return thoiGianDuKienDichVu;
    }

    public void setThoiGianDuKienDichVu(String thoiGianDuKienDichVu) {
        this.thoiGianDuKienDichVu = thoiGianDuKienDichVu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
