package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class regestr extends AppCompatActivity {
 EditText mFullName, mEmail, mPassword, mPhone;
 Button mRegisterBtn, mlogin;
 FirebaseAuth fAuth;
 ProgressBar progressBar;
 FirebaseDatabase rootnode;
 DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestr);

        mFullName = findViewById(R.id.fullname);
        mEmail  = findViewById(R.id.email);
        mPassword= findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerbutton);
        mlogin =  findViewById(R.id.loginbtm);
        mlogin =  findViewById(R.id.loginbtm);



        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("users");


                String fullname = mFullName.getEditableText().toString().trim();
                String email = mEmail.getEditableText().toString().trim();
                String password = mPassword.getEditableText().toString().trim();
                String phone = mPhone.getEditableText().toString().trim();

                helper help = new helper(fullname ,email,password,phone);

                reference.child(phone).setValue(help);


            }
        });
        
    }
}