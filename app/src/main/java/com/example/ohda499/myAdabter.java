package com.example.ohda499;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class myAdabter extends RecyclerView.ViewHolder {
    public    TextView type , filename;
    public ImageView i1;

    public myAdabter(@NonNull View itemView) {
        super(itemView);
        type = (TextView)itemView.findViewById(R.id.type);
        filename = (TextView)itemView.findViewById(R.id.namef);
        i1 = (ImageView)itemView.findViewById(R.id.imageview);


    }

}

