package com.example.e_shop.ui.phonesParts;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.e_shop.ui.fixPhones.FixPhones;
import com.example.e_shop.ui.fixPhones.FixPhonesDAO;
import com.example.e_shop.ui.fixPhones.FixPhonesDB;

@Database(entities = {Parts.class}, exportSchema = false, version = 1)
public abstract class PartsDB extends RoomDatabase {
    public abstract PartsDAO getDao();
    private static PartsDB instance2;

    static PartsDB getDatabase2(final Context context){
        if (instance2 == null){
            synchronized (PartsDB.class){
                instance2 = Room.databaseBuilder(context, PartsDB.class, "PDATABASE").allowMainThreadQueries().build();
            }
        }
        return instance2;
    }
}
