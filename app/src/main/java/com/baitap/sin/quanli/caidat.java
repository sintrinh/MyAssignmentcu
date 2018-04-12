package com.baitap.sin.quanli;

/**
 * Created by FancaoFaker on 9/27/2016.
 */
public class caidat {

    private int caidat_Id;
    String idkhoanthuchi ;
    public String tenkhoanthuchi;

    public caidat(String idkhoanthuchi, String tenkhoanthuchi) {
        this.caidat_Id = caidat_Id;
        this.idkhoanthuchi = idkhoanthuchi;
        this.tenkhoanthuchi = tenkhoanthuchi;
    }

    public caidat() {
    }

    public int getCaidat_Id() {
        return caidat_Id;
    }

    public void setCaidat_Id(int caidat_Id) {
        this.caidat_Id = caidat_Id;
    }

    public String getIdkhoanthuchi() {
        return idkhoanthuchi;
    }

    public void setIdkhoanthuchi(String idkhoanthuchi) {
        this.idkhoanthuchi = idkhoanthuchi;
    }

    public String getTenkhoanthuchi() {
        return tenkhoanthuchi;
    }

    public void setTenkhoanthuchi(String tenkhoanthuchi) {
        this.tenkhoanthuchi = tenkhoanthuchi;
    }

    @Override
    public String toString() {
        return tenkhoanthuchi ;
    }
}
