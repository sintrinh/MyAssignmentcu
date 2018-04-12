package com.baitap.sin.quanli;

public class viewds_class {
    public int magd;
    public String taikhoan;
    public String loaigiaodich;
    public String phannhom;
    public int sotien;
    public String lydo;
    public String ngay;

    public viewds_class() {
    }

    public viewds_class(int magd, String taikhoan, String loaigiaodich, String phannhom, int sotien, String lydo, String ngay) {
        this.magd = magd;
        this.taikhoan = taikhoan;
        this.loaigiaodich = loaigiaodich;
        this.phannhom = phannhom;
        this.sotien = sotien;
        this.lydo = lydo;
        this.ngay = ngay;
    }

    public int getMagd() {
        return magd;
    }

    public void setMagd(int magd) {
        this.magd = magd;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getLoaigiaodich() {
        return loaigiaodich;
    }

    public void setLoaigiaodich(String loaigiaodich) {
        this.loaigiaodich = loaigiaodich;
    }

    public String getPhannhom() {
        return phannhom;
    }

    public void setPhannhom(String phannhom) {
        this.phannhom = phannhom;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    @Override
    public String toString() {
        return taikhoan+loaigiaodich;
    }
}
