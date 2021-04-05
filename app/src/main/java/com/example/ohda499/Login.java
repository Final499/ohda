package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText mPassword, mPhoneq;
        Button log;
        TextView noaccount;
        String h ;

SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        mPhoneq = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        log = findViewById(R.id.loginbutton);
        noaccount = findViewById(R.id.haveAcount);


        noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentTransaction Frag = getSupportFragmentManager().beginTransaction();
               // Frag.replace(R.id.loginmain,new profiled()).commit();
                Intent intent = new Intent(Login.this, regestr.class);
               startActivity(intent);

            }
        });

        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Login(v);
               // DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users").child("phone");

            }
        });

    }
    private boolean validPhone() {
        String valu = mPhoneq.getEditableText().toString().trim();

        if (valu.isEmpty()) {
            mPhoneq.setError("Phone is required ! ");
            return false;
        } else if (mPhoneq.length() != 10) {
            mPhoneq.setError("Phone must be 10 numbers ! ");
            return false;
        } else {

            mPhoneq.setError(null);

            return true;
        }
    }
    private boolean validPass(){
        String valu = mPassword.getEditableText().toString().trim();

        if(valu.isEmpty()){
            mPassword.setError("Password is required ! ");
            return false;
        }
        else{
            mPassword.setError(null);
            return true;
        }

    }
    public void Login (View view){
       if (!validPass()|!validPhone()){
            return;
       }else{
          isUser();
       }
    }

    private void isUser() {


     String userphone = mPhoneq.getText().toString().trim();
     String userpass = mPassword.getText().toString().trim();
     DatabaseReference reference  = FirebaseDatabase.getInstance().getReference("users");
     Query check = reference.orderByChild("phone").equalTo(userphone);
        check.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {



             if (snapshot.exists()) {
                 mPassword.setError(null);
                 String passDB = snapshot.child(userphone).child("password").getValue(String.class);

                 if (passDB.equals(userpass)) {
                     mPassword.setError(null);
                     String emailDB = snapshot.child(userphone).child("email").getValue(String.class);
                     String phoneDB  = snapshot.child(userphone).child("phone").getValue(String.class);
                     String nameDB = snapshot.child(userphone).child("fname").getValue(String.class);

                     Intent intent = new Intent(getApplicationContext(), homebage.class);
           intent.putExtra("email",emailDB);
           intent.putExtra("fname",nameDB);
           intent.putExtra("password",passDB);
          intent.putExtra("phone",phoneDB);
         //  System.out.println(phoneDB);


                     startActivity(intent);
                     finish();




                 } else {
                     mPassword.setError("Wrong Password");
                     mPassword.requestFocus();
                 }
             }else {
                 mPhoneq.setError("No such user exist");
             }
         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {
             Toast.makeText(Login.this, error.getMessage(),Toast.LENGTH_SHORT).show();
         }
     });

    }

}