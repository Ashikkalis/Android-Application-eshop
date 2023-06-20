package com.example.e_shop.ui.salePhones;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.e_shop.ui.phonesParts.Parts;

import java.util.List;

@Dao
public interface SalePhoneDAO {

    @Insert
    void insertAllData3(SalePhones salePhones);

    //Select All Data
    @Query("SELECT * FROM salephone")
    List<SalePhones> getAllData3();

    //Delete data

    @Query("DELETE  FROM salephone WHERE sphoneid = :spid")
    void deleteData3(int spid);


    //Update
    @Query("UPDATE salephone SET sphoneName = :sphonesName, sphoneModel = :sphonesModel WHERE sphoneid = :spid")
    void updateData3(String sphonesName, String sphonesModel, int spid);
}
