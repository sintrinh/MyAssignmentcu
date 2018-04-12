package com.baitap.sin.quanli;

public class Tenkhoanthuchi {
    public int ID_khoanthuchi;
    public String name_khoanthuchi;
    public int IDD_ngoai_khoanthuchi;

    public Tenkhoanthuchi() {
    }

    public Tenkhoanthuchi(int idkhoanthuchi, String tenkhoanthuchi, int iddngoaithuchi) {
        this.ID_khoanthuchi = idkhoanthuchi;
        this.name_khoanthuchi = tenkhoanthuchi;
        this.IDD_ngoai_khoanthuchi = iddngoaithuchi;
    }

    public int getIdkhoanthuchi() {
        return ID_khoanthuchi;
    }

    public void setIdkhoanthuchi(int idkhoanthuchi) {
        this.ID_khoanthuchi = idkhoanthuchi;
    }

    public String getTenkhoanthuchi() {
        return name_khoanthuchi;
    }

    public void setTenkhoanthuchi(String tenkhoanthuchi) {
        this.name_khoanthuchi = tenkhoanthuchi;
    }

    public int getIddngoaithuchi() {
        return IDD_ngoai_khoanthuchi;
    }

    public void setIddngoaithuchi(int iddngoaithuchi) {
        this.IDD_ngoai_khoanthuchi = iddngoaithuchi;
    }

    @Override
    public String toString() {
        return name_khoanthuchi;
    }
}
