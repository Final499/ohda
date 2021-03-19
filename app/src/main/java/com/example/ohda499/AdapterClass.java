package com.example.ohda499;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder>{

ArrayList<masseges> list;



public AdapterClass(ArrayList<masseges> list)
{
    this.list=list;

}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    myViewHolder.id.setText(list.get(i).getFilename());
    myViewHolder.desc.setText(list.get(i).getDescription());
       Picasso.get().load(list.get(i).getmImageUrl()).into(myViewHolder.image);
        String a = list.get(i).getPhoneid();
        a.substring(1);
        myViewHolder.con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=966"+a));
                v.getContext().startActivity(intent);

            }
        });





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
    TextView id ,desc;
    ImageView image;
    Button con ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.fileName);
            desc= itemView.findViewById(R.id.description);
            image= itemView.findViewById(R.id.image_search);
            con= itemView.findViewById(R.id.con4);

        }
    }

}
