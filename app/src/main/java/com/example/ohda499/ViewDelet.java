package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ViewDelet extends AppCompatActivity {
    TextView fn , ty, de,ty2;
    ImageView imageView;
    Button co , back;
    DatabaseReference ref, dataRef   ;
    StorageReference storageReference;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_view_delet);
        imageView = findViewById(R.id.imageDe);
        fn = findViewById(R.id.fileName);
        ty = findViewById(R.id.adress);
        ty2 = findViewById(R.id.type2);
        de = findViewById(R.id.des);
        co = findViewById(R.id.con);
        ref = FirebaseDatabase.getInstance().getReference().child("items");

        String key = getIntent().getStringExtra("fname");

        System.out.println(key);
        ref.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){


                    String fName = snapshot.child("filename").getValue().toString();
                    String tyname = snapshot.child("userAdress").getValue().toString();
                    String tyname2 = snapshot.child("type2").getValue().toString();
                    String deName = snapshot.child("description").getValue().toString();
                    String imageName = snapshot.child("mImageUrl").getValue().toString();

                    phone = snapshot.child("phoneid").getValue().toString();

                    Picasso.get().load(imageName).into(imageView);
                    fn.setText(fName);
                    ty.setText(tyname);
                    ty2.setText(tyname2);

                    de.setText(deName);

                    co.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("items").child(phone);
                            ref.removeValue();
                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}