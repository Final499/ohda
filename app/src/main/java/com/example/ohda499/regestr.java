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
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerbutton);
        mRegisterBtn = findViewById(R.id.registerbutton);


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("users");
                registerUser(v);


            }
        });
        mlogin = findViewById(R.id.loginbtm);

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(regestr.this,Login.class);
                startActivity(intent);
            }
        });
    }

    public void registerUser(View view) {
        if (!validname() | !valiemail() | !validPhone() | !validPass()) {
            return;
        }
        String fullname = mFullName.getEditableText().toString().trim();
        String email = mEmail.getEditableText().toString().trim();
        String password = mPassword.getEditableText().toString().trim();
        String phone = mPhone.getEditableText().toString().trim();

        helper help = new helper(fullname, email, password, phone);

        reference.child(password).setValue(help);
        Intent intent = new Intent(regestr.this,MainActivity.class);
        startActivity(intent);

    }

    private boolean validname() {
        String valu = mFullName.getEditableText().toString().trim();
        if (valu.isEmpty()) {
            mFullName.setError("Name is required ! ");
            return false;
        } else {
            mFullName.setError(null);

            return true;
        }

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

    private boolean validPhone() {
        String valu = mPassword.getEditableText().toString().trim();

        if (valu.isEmpty()) {
            mPassword.setError("Phone is required ! ");
            return false;
        } else if (mPassword.length() == 10) {
            mPassword.setError("Phone must be 10 numbers ! ");
            return false;
        } else {

            mPassword.setError(null);

            return true;
        }
    }



    private boolean validPass(){
        String valu = mPhone.getEditableText().toString().trim();
        String passvald= "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if(valu.isEmpty()){
            mPhone.setError("Password is required ! ");
            return false;
        }else if(!valu.matches(passvald)){
            mPhone.setError("Password is weak !");
           return false;

        }
        else{
            mPhone.setError(null);
            return true;
        }

    }
}