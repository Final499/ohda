package com.example.ohda499;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          getSupportActionBar().hide();
          Thread thread = new Thread(){
              @Override
              public void run() {
                  try {
                      sleep(3000);
                      Intent intent = new Intent(getApplicationContext(),Login.class);
                      startActivity(intent);
                      finish();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          };
         thread.start();
    }
}