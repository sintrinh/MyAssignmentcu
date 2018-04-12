package com.baitap.sin.quanli;

public class thongke {
    String loaithongke ;
    Integer tien ;


    public thongke(String loaithongke, Integer tien) {
        this.loaithongke = loaithongke;
        this.tien = tien;
    }

    public thongke() {

    }

    public String getLoaithongke() {
        return loaithongke;
    }

    public void setLoaithongke(String loaithongke) {
        this.loaithongke = loaithongke;
    }

    public Integer getTien() {
        return tien;
    }

    public void setTien(Integer tien) {
        this.tien = tien;
    }

    @Override
    public String toString() {
        return loaithongke +"-"+ tien ;
    }
}
