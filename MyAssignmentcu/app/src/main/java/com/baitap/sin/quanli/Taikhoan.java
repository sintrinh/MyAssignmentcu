package com.baitap.sin.quanli;


public class Taikhoan {
    public int idtaikhoan;
    public String loaiTaiKhoan;
    public int sotien;
    public int idloaithuchi;

    public Taikhoan() {
    }

    public Taikhoan(int idtaikhoan, String loaiTaiKhoan, int sotien, int idngoaithuchi) {
        this.idtaikhoan = idtaikhoan;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.sotien = sotien;
        this.idloaithuchi = idngoaithuchi;
    }

    public int getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(int idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public int getIdngoaithuchi() {
        return idloaithuchi;
    }

    public void setIdngoaithuchi(int idngoaithuchi) {
        this.idloaithuchi = idngoaithuchi;
    }

    @Override
    public String toString() {
        return idtaikhoan+"";
    }
}
