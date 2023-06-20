package com.example.e_shop.ui.salePhones;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "salephone")
public class SalePhones {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int sphoneid;

    @ColumnInfo(name = "sphoneName")
    private String sphoneName;

    @ColumnInfo(name = "sphoneModel")
    private String sphoneModel;

    public int getSphoneid() {
        return sphoneid;
    }

    public void setSphoneid(int sphoneid) {
        this.sphoneid = sphoneid;
    }

    public String getSphoneName() {
        return sphoneName;
    }

    public void setSphoneName(String sphoneName) {
        this.sphoneName = sphoneName;
    }

    public String getSphoneModel() {
        return sphoneModel;
    }

    public void setSphoneModel(String sphoneModel) {
        this.sphoneModel = sphoneModel;
    }
}
