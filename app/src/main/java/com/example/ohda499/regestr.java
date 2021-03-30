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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class regestr extends AppCompatActivity {
    EditText mFullName, mEmail, mPassword, mPhone;
    Button mRegisterBtn, mlogin;

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    TextView noaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestr);
        getSupportActionBar().hide();


        mFullName = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerbutton);
        mRegisterBtn = findViewById(R.id.registerbutton);

        noaccount = findViewById(R.id.haveAcount);
        noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FragmentTransaction Frag = getSupportFragmentManager().beginTransaction();
                //    Frag.replace(R.id.loginmain,new profiled()).commit();
                Intent intent = new Intent(regestr.this, Login.class);
                startActivity(intent);

            }
        });


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode = FirebaseDatabase.getInstance();
                //reference = rootnode.getReference("users").child("054");
                reference = rootnode.getReference("users");
                registerUser(v);
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println(mPassword);

            }
        });


    }

    public void registerUser(View view) {


        String fullname = mFullName.getEditableText().toString().trim();
        String email = mEmail.getEditableText().toString().trim();
        String password = mPassword.getEditableText().toString().trim();
        String phone = mPhone.getEditableText().toString().trim();
        Query check = FirebaseDatabase.getInstance().getReference("users").orderByChild("phone").equalTo(phone);
        check.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Toast.makeText(regestr.this, "Phone alredy exiset ", Toast.LENGTH_SHORT).show();


                }else {
                    if (!validname() | !valiemail(email,0) | !validPhone(phone,0) | !validPass()) {
                        return;
                    }
                    helper help = new helper(fullname, email, phone, password);

                    reference.child(phone).setValue(help);
                    Intent intent = new Intent(regestr.this,homebage.class);
                    intent.putExtra("phone",phone);
                    startActivity(intent);
                    finish();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


     //   FragmentTransaction Frag = getSupportFragmentManager().beginTransaction();
       // Frag.replace(R.id.regesternmain,new home()).commit();

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

    public boolean valiemail(String valu,int i) {

        if (i==0){
            valu = mEmail.getEditableText().toString().trim();
        }

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (valu.isEmpty()) {
            if (i==0)
            mEmail.setError("Email is required ! ");
            return false;
        } else if (!valu.matches(emailPattern)) {
            if(i==0)
            mEmail.setError("Invalid email address ! ");
            return false;

        } else {
            if (i==0)
            mEmail.setError(null);

            return true;
        }

    }


    public boolean validPhone(String valu,int i) {
        if (i==0) {
            valu = mPhone.getEditableText().toString().trim();
        }
        if (valu.isEmpty()) {
            if (i==0)
                mPhone.setError("Phone is required ! ");
            return false;
        } else if (valu.length() != 10) {
            if (i==0)
                mPhone.setError("Phone must be 10 numbers ! ");
            return false;
        } else {
            if (i==0)
                mPhone.setError(null);

            return true;
        }
    }



    private boolean validPass(){
        String valu = mPassword.getEditableText().toString().trim();
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
            mPassword.setError("Password is required ! ");
            return false;
        }else if(!valu.matches(passvald)){
            mPassword.setError("Password is weak !");
           return false;

        }
        else{
            mPassword.setError(null);
            return true;
        }

    }
}