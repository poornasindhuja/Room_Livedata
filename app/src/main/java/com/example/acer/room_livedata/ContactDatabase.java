package com.example.acer.room_livedata;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {MyContact.class},version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();

    private static ContactDatabase instance;

    public static  ContactDatabase getInstance(Context context){

        if(instance==null) {

            instance = Room.databaseBuilder(context, ContactDatabase.class, "Contact").fallbackToDestructiveMigration().build();
        }

        return instance;
    }

}
