package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ViewActivity extends AppCompatActivity {
TextView fn , ty, de;
ImageView imageView;
Button co;
DatabaseReference ref ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        imageView = findViewById(R.id.imageDe);
        fn = findViewById(R.id.fileName);
        ty = findViewById(R.id.type);
        de = findViewById(R.id.des);
        co = findViewById(R.id.con);
        ref = FirebaseDatabase.getInstance().getReference().child("items");

        String key = getIntent().getStringExtra("fname");

        ref.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String fName = snapshot.child("filename").getValue().toString();
                    String tyname = snapshot.child("type").getValue().toString();
                    String deName = snapshot.child("description").getValue().toString();
                    String imageName = snapshot.child("mImageUrl").getValue().toString();
                    Picasso.get().load(imageName).into(imageView);
                    fn.setText(fName);
                    ty.setText(tyname);
                    de.setText(deName);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}