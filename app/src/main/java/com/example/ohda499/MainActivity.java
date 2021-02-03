package com.example.ohda499;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private ImageButton imageButtonh;
private ImageButton imageButtonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButtonh = findViewById(R.id.imageButton3);
        imageButtonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,regestr.class);
                startActivity(intent);
            }

        });

        imageButtonAdd = findViewById(R.id.imageButton8);
        imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,add_item.class);
                startActivity(intent);
            }
        });




    }
}