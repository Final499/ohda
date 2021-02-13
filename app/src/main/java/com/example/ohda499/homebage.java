package com.example.ohda499;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

public class homebage extends AppCompatActivity {
    private ImageButton imageButtonh;
    private ImageButton imageButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homebage);
        imageButtonh = findViewById(R.id.imageButton3);

        imageButtonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homebage.this,regestr.class);
                startActivity(intent);
            }

        });

        imageButtonAdd = findViewById(R.id.imageButton8);
        imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homebage.this,add_item.class);
                startActivity(intent);
            }
        });




    }
}