package com.example.e_shop.ui.fixPhones;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FixPhones.class}, exportSchema = false, version = 1)
public abstract class FixPhonesDB extends RoomDatabase {
    public abstract FixPhonesDAO getDao_FixPhones();
    private static FixPhonesDB instance;

    static FixPhonesDB getDatabase(final Context context){
        if (instance == null){
            synchronized (FixPhonesDB.class){
                instance = Room.databaseBuilder(context, FixPhonesDB.class, "FDATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;
    }
}
