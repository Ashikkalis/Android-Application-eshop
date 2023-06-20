package com.example.e_shop.ui.fixPhones;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FixPhonesDAO {
    @Insert
    void insertAllData(FixPhones fixPhones);

    //Select All Data
    @Query("SELECT * FROM fixphones")
    List<FixPhones> getAllData();

    //Delete data

    @Query("DELETE  FROM fixphones WHERE phoneid = :fid")
    void deleteData(int fid);


    //Update
    @Query("UPDATE fixphones SET phoneName = :phonesName, phoneModel = :phonesModel WHERE phoneid = :fid")
    void updateData(String phonesName, String phonesModel, int fid);
}
