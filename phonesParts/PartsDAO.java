package com.example.e_shop.ui.phonesParts;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.e_shop.ui.fixPhones.FixPhones;

import java.util.List;

@Dao
public interface PartsDAO {
    @Insert
    void insertAllData(Parts parts);

    //Select All Data
    @Query("SELECT * FROM parts")
    List<Parts> getAllData2();

    //Delete data

    @Query("DELETE  FROM parts WHERE partsid = :pid")
    void deleteData2(int pid);


    //Update
    @Query("UPDATE parts SET partName = :partsName, phonePart = :PhonesPart WHERE partsid = :pid")
    void updateData2(String partsName, String PhonesPart, int pid);
}
