package com.example.e_shop.ui.salePhones;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.e_shop.ui.phonesParts.Parts;
import com.example.e_shop.ui.phonesParts.PartsDAO;
import com.example.e_shop.ui.phonesParts.PartsDB;

@Database(entities = {SalePhones.class}, exportSchema = false, version = 1)
public abstract class SalePhoneDB extends RoomDatabase {
    public abstract SalePhoneDAO getDao_salephone();
    private static SalePhoneDB instance3;

    static SalePhoneDB getDatabase3(final Context context){
        if (instance3 == null){
            synchronized (SalePhoneDB.class){
                instance3 = Room.databaseBuilder(context, SalePhoneDB.class, "SDATABASE").allowMainThreadQueries().build();
            }
        }
        return instance3;
    }
}
