package com.example.acer.room_livedata;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class ContactRepository {

    public static ContactDao myDao;

    LiveData<List<MyContact>> liveData;

    public ContactRepository(Context context) {
        ContactDatabase contactDatabase=ContactDatabase.getInstance(context);
        myDao=contactDatabase.contactDao();
        liveData=myDao.getAllContacts();
    }

    LiveData<List<MyContact>> getAlContacts(){
        return liveData;
    }

    public void insert(MyContact myContact){
        new insertTask().execute(myContact);
    }

    public void deleteAll(){
        new DeleteAllTask().execute();
    }

    public void update(MyContact myContact){
        new UpdateTask().execute(myContact);
    }

    public void delete(MyContact myContact){
        new DeleteTask().execute(myContact);
    }


    public class insertTask extends AsyncTask<MyContact,Void,Void>{

        @Override
        protected Void doInBackground(MyContact... myContacts) {
            myDao.insertContact(myContacts[0]);
            return null;
        }
    }

    public class UpdateTask extends AsyncTask<MyContact,Void,Void>{
        @Override
        protected Void doInBackground(MyContact... myContacts) {
            myDao.updateContact(myContacts[0]);
            return null;
        }
    }

    public class DeleteTask extends AsyncTask<MyContact,Void,Void>{
        @Override
        protected Void doInBackground(MyContact... myContacts) {
            myDao.deleteData(myContacts[0]);
            return null;
        }
    }

    public class DeleteAllTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            myDao.deletaAll();
            return null;
        }
    }
}
