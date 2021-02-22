package com.example.ohda499;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homebage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homebage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigation);
        NavController navController = Navigation.findNavController(this,R.id.fragment2);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);




    }
}