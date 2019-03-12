package com.example.acer.room_livedata;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert
    public void insertContact(MyContact myContact);

    @Update
    public void updateContact(MyContact myContact);

    @Delete
    public void deleteData(MyContact myContact);

    @Query("select * from contact_details")
    public LiveData<List<MyContact>> getAllContacts();

    @Query("Delete from contact_details")
    public void deletaAll();

}
