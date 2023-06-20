package com.example.e_shop.ui.phonesParts;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "parts")
public class Parts {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int partsid;

    @ColumnInfo(name = "partName")
    private String partName;

    @ColumnInfo(name = "phonePart")
    private String phonePart;

    public int getPartsid() {
        return partsid;
    }

    public void setPartsid(int partsid) {
        this.partsid = partsid;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPhonePart() {
        return phonePart;
    }

    public void setPhonePart(String phonePart) {
        this.phonePart = phonePart;
    }
}
