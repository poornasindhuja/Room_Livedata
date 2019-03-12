package com.example.acer.room_livedata;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "contact_details")
public class MyContact {
    @PrimaryKey @NonNull @ColumnInfo(name = "contact_id")
    String id;
    String name,mail_id,number;

    @NonNull
    public String getId() {
        return id;
    }

    public MyContact() {
    }

    public MyContact(@NonNull String id, String name, String mail_id, String number) {

        this.id = id;
        this.name = name;
        this.mail_id = mail_id;
        this.number = number;
    }

    public void setId(@NonNull String id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
