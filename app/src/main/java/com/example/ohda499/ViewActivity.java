package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ViewActivity extends AppCompatActivity {
TextView fn , ty, de,ty2;
ImageView imageView;
Button co , back;
DatabaseReference ref ;

    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      getSupportActionBar().hide();
        String hu = "Hello";

        setContentView(R.layout.activity_view);
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
                    phone.substring(1);

                    co.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean installed = isAppInstalled("com.whatsapp");
                            if(installed){
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=966"+phone+"&text="+hu));
                                startActivity(intent);
                            } else {
                                Toast.makeText(ViewActivity.this, "Whatsapp is not installed !!",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed ;
        try{
            packageManager.getPackageInfo(s,PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return  is_installed;
    }

}