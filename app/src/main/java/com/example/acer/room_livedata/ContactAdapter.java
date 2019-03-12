package com.example.acer.room_livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    Context context;
    List<MyContact> contacts;


    public ContactAdapter(MainActivity mainActivity, List<MyContact> myContacts) {
        context=mainActivity;
        contacts=myContacts;
    }

    @NonNull
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.rowdesign,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MyViewHolder holder, final int position) {

        final MyContact contact=contacts.get(position);
        holder.cid.setText(contact.getId());
        holder.cmail.setText(contact.getMail_id());
        holder.cphno.setText(contact.getNumber());
        holder.cname.setText(contact.getName());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] values=new String[4];
                values[0]=contacts.get(position).getId();
                values[1]=contacts.get(position).getNumber();
                values[2]=contacts.get(position).getName();
                values[3]=contacts.get(position).getMail_id();
                Intent intent=new Intent(context,UpdateActivity.class);
                intent.putExtra("data",values);
                context.startActivity(intent);
            }
        });
        holder.delt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dcontact=contacts.get(position).getId();
                Intent i=new Intent(context,MainActivity.class);
                i.putExtra("contact",dcontact);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cid,cname,cphno,cmail;
        ImageView edit,delt;
        public MyViewHolder(View itemView) {
            super(itemView);
            cid=itemView.findViewById(R.id.rid);
            cname=itemView.findViewById(R.id.rname);
            cphno=itemView.findViewById(R.id.rphone);
            cmail=itemView.findViewById(R.id.rmail);
            edit=itemView.findViewById(R.id.redit);
            delt=itemView.findViewById(R.id.del);
        }
    }
}
