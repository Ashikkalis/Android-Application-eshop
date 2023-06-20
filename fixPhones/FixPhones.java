package com.example.e_shop.ui.fixPhones;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fixphones")
public class FixPhones {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int phoneid;

    @ColumnInfo(name = "phoneName")
    private String phoneName;

    @ColumnInfo(name = "phoneModel")
    private String phoneModel;

//    @ColumnInfo(name = "phoneProb")
//    private String phoneProb;

    public int getPhoneid() {
        return phoneid;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneid(int phoneid) {
        this.phoneid = phoneid;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

//    public String getPhoneProb() {
//        return phoneProb;
//    }
//
//    public void setPhoneProb(String phoneProb) {
//        this.phoneProb = phoneProb;
//    }
}
