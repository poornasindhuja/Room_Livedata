package com.example.acer.room_livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText id,name,phNo,mail;
    Button addbutton;

    ContactViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        id=findViewById(R.id.a_id);
        name=findViewById(R.id.a_name);
        phNo=findViewById(R.id.a_phno);
        mail=findViewById(R.id.a_mail);
        addbutton=findViewById(R.id.badd);

        viewModel=ViewModelProviders.of(this).get(ContactViewModel.class);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyContact contact=new MyContact();
                contact.setId(id.getText().toString());
                contact.setName(name.getText().toString());
                contact.setMail_id(mail.getText().toString());
                contact.setNumber(phNo.getText().toString());
                viewModel.insertData(contact);

                finish();
            }
        });

    }
}
