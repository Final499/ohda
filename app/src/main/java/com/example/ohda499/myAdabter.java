package com.example.ohda499;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdabter extends RecyclerView.ViewHolder {
    public    TextView userAdress , filename , type2;
    public ImageView i1;
    View v;

    public myAdabter(@NonNull View itemView) {
        super(itemView);
        userAdress = (TextView)itemView.findViewById(R.id.adress);
        type2 = (TextView)itemView.findViewById(R.id.textView9);
        filename = (TextView)itemView.findViewById(R.id.namef);
        i1 = (ImageView)itemView.findViewById(R.id.imageviewg);
        v=itemView;


    }

}

