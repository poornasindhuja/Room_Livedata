package com.example.acer.room_livedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    public ContactRepository contactRepository;

    public LiveData<List<MyContact>> getAllContactsData;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        contactRepository=new ContactRepository(application);
        getAllContactsData=contactRepository.getAlContacts();
    }

    public void insertData(MyContact myContact){
        contactRepository.insert(myContact);
    }
    public void updateDta(MyContact myContact){
        contactRepository.update(myContact);
    }
    public void deleteData(MyContact myContact){
        contactRepository.delete(myContact);
    }
    public void deleteAllData(){
        contactRepository.deleteAll();
    }

    public LiveData<List<MyContact>> getAllContacts(){
        return getAllContactsData;
    }
}
