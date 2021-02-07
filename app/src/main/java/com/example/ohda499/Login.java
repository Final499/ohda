package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        if (!validPass()|valiemail()){
            return;
        }else{
           isUser();
        }


    }

    private void isUser() {
        String useremail = mEmail.getText().toString().trim();
        String userpass = mPhone.getText().toString().trim();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query check = reference.orderByChild("email").equalTo(userpass);
        check.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    mEmail.setError(null);

                    String passDB = snapshot.child(useremail).child("password").getValue(String.class);
                    if(passDB.equals(userpass)){
                        String nameDB = snapshot.child(useremail).child("fname").getValue(String.class);
                        String emailDB = snapshot.child(useremail).child("email").getValue(String.class);
                        String phoneDB = snapshot.child(useremail).child("phone").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("fname",nameDB);
                        intent.putExtra("email",emailDB);
                        intent.putExtra("phone",phoneDB);
                        intent.putExtra("password",passDB);
                        startActivity(intent);

                    }
                    else {
                      mPhone.setError("Wrong Password");
                      mPhone.requestFocus();
                    }
                }
                else {
                    mEmail.setError("no such User exist");
                    mPhone.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}