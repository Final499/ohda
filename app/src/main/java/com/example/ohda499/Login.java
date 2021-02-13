package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText mEmail, mPhone;
        Button log;
        TextView noaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail = findViewById(R.id.email);
        mPhone = findViewById(R.id.password);
        log = findViewById(R.id.loginbutton);

        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Login(v);
               // DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users").child("phone");

            }
        });

    }
    private boolean valiemail() {
       String valu = mEmail.getEditableText().toString().trim();
       String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

       if (valu.isEmpty()) {
           mEmail.setError("Email is required ! ");
           return false;
       } else if (!valu.matches(emailPattern)) {
            mEmail.setError("Invalid email address ! ");
           return false;

        } else {
           mEmail.setError(null);

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
   //    if (!validPass()|!valiemail()){
     //       return;
    //   }else{
          isUser();
      //  }
    }

    private void isUser() {


     String useremail = mEmail.getText().toString().trim();
     String userpass = mPhone.getText().toString().trim();
     //DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users").child(useremail);
     Query check = FirebaseDatabase.getInstance().getReference("users").orderByChild("phone").equalTo(useremail);
     check.addListenerForSingleValueEvent(new ValueEventListener() {
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