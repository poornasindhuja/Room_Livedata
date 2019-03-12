package com.example.acer.room_livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    EditText name,phNo,mail;
    TextView id;
    Button updatebt;

    ContactViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        id=findViewById(R.id.u_id);
        name=findViewById(R.id.u_name);
        phNo=findViewById(R.id.u_phno);
        mail=findViewById(R.id.u_mail);
        updatebt=findViewById(R.id.bupdate);

        viewModel=ViewModelProviders.of(this).get(ContactViewModel.class);

        String[] res=getIntent().getStringArrayExtra("data");
        id.setText(res[0]);
        name.setText(res[2]);
        phNo.setText(res[1]);
        mail.setText(res[3]);

        updatebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyContact contact= new MyContact();
                contact.setNumber(phNo.getText().toString());
                contact.setMail_id(mail.getText().toString());
                contact.setName(name.getText().toString());
                contact.setId(id.getText().toString());
                viewModel.updateDta(contact);
                finish();
                //MyContact contact=new
                //viewModel.updateDta();
            }
        });
    }
}
