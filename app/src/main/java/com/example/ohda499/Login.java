package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    EditText mPassword, mPhone;
        Button log;
        TextView noaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPassword = findViewById(R.id.email);
        mPhone = findViewById(R.id.password);
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
        String valu = mPassword.getEditableText().toString().trim();

        if (valu.isEmpty()) {
            mPassword.setError("Phone is required ! ");
            return false;
        } else if (mPassword.length() != 10) {
            mPassword.setError("Phone must be 10 numbers ! ");
            return false;
        } else {

            mPassword.setError(null);

            return true;
        }
    }
    private boolean validPass(){
        String valu = mPhone.getEditableText().toString().trim();

        if(valu.isEmpty()){
            mPhone.setError("Password is required ! ");
            return false;
        }
        else{
            mPhone.setError(null);
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


     String useremail = mPassword.getText().toString().trim();
     String userpass = mPhone.getText().toString().trim();
     DatabaseReference reference  = FirebaseDatabase.getInstance().getReference().child("users").child(useremail);
     //Query check = FirebaseDatabase.getInstance().getReference("users").orderByChild("phone").equalTo(useremail);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {

             String emailDB = snapshot.child("phone").getValue().toString();
             String phoneDB = snapshot.child("password").getValue().toString();
             System.out.println(emailDB);
             System.out.println("-----------------------------------");

             if (snapshot.exists()) {


                 if (phoneDB.equals(userpass)) {
                     mPhone.setError(null);
                     Intent intent = new Intent(Login.this, homebage.class);
                     startActivity(intent);
                     finish();

                 } else {
                     mPhone.setError("Wrong Password");
                     mPhone.requestFocus();
                 }
             }else {
                 Toast.makeText(Login.this, "No user",Toast.LENGTH_SHORT).show();
             }
         }

         @Override
         public void onCancelled(@NonNull DatabaseError error) {
             Toast.makeText(Login.this, error.getMessage(),Toast.LENGTH_SHORT).show();
         }
     });

    }

}