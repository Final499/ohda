package com.example.ohda499;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profiled#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class profiled extends Fragment {
    EditText mFullName, mEmail, mPassword, mPhone;
    Button mRegisterBtn, mlogin, bb,logout;
     TextView  hAcount;
    FirebaseDatabase rootnode;



    private Button mUpdate;

    private EditText name,email, password ,phone;
    String _name,_email, _password,_phone;
    DatabaseReference Reference;
    private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profiled.
     */
    // TODO: Rename and change types and number of parameters
    public static profiled newInstance(String param1, String param2) {
        profiled fragment = new profiled();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public profiled() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profiled, container, false);
        bb = v.findViewById(R.id.button);
        logout = v.findViewById(R.id.logout);
        Reference=FirebaseDatabase.getInstance().getReference("users");

        name= v.findViewById(R.id.NewName);
        email=v.findViewById(R.id.NewEmail);
        password =v.findViewById(R.id.NewPassward);
        mUpdate =v.findViewById(R.id.Update);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent intent=new Intent(getActivity(),Login.class);
        startActivity(intent);
        getActivity().finish();
                Toast.makeText(getActivity(), "out", Toast.LENGTH_SHORT).show();


        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ItemThatIadd.class);
                intent.putExtra("phone", _phone);
                startActivity(intent);
            }
        });


        showAllUserData();

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (registerUser(v)){
                    update(v);
                }


            }
        });


        return v;
    }
    public boolean registerUser(View view) {
        if (!validname() | !valiemail() | !validPass()) {
            return false;
        }

    return true; }
    private boolean valiemail() {
        String valu = email.getEditableText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (valu.isEmpty()) {
            email.setError("Email is empty ! ");
            return false;
        } else if (!valu.matches(emailPattern)) {
            email.setError("Invalid email address ! ");
            return false;

        } else {

            email.setError(null);
            return true;
        }

    }
    private boolean validname() {
        String valu = name.getEditableText().toString().trim();
        if (valu.isEmpty()) {
            name.setError("Name is Empty ! ");
            return false;
        } else {
            name.setError(null);

            return true;
        }

    }
    private boolean validPass(){
        String valu = password.getEditableText().toString().trim();
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
            password.setError("Password is required ! ");
            return false;
        }else if(!valu.matches(passvald)){
            password.setError("Password is weak !");
            return false;

        }
        else{
            password.setError(null);
            return true;
        }

    }
    private void showAllUserData() {


        Intent intent= getActivity().getIntent();
        _name=intent.getStringExtra("fname");
        _email=intent.getStringExtra("email");
        _password =intent.getStringExtra("password");
        _phone =intent.getStringExtra("phone");
        intent.putExtra("phone", _phone);




        name.setText(_name);
        email.setText(_email);
        password.setText(_password);


    }

    public void update (View viwe){

        if (isNameChanged() || isEmaillChanged() || isPasswordChanged()){

            Toast.makeText(getActivity() , "Data has been updated", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity() , "There is no change in data", Toast.LENGTH_SHORT).show();
        }

    }
    private boolean isNameChanged() {
        if (!_name.equals(name.getText().toString())) {
            Reference.child(_phone).child("fname").setValue(name.getText().toString());
            return true;
        }else {
            return false;
        }
    }
    private boolean isEmaillChanged() {
        if (!_email.equals(email.getText().toString())) {
            Reference.child(_phone).child("email").setValue(email.getText().toString());
            return true;
        }else {
            return false;
        }
    }   
    private boolean isPasswordChanged() {
        if (!_password.equals(password.getText().toString())) {
            Reference.child(_phone).child("password").setValue(password.getText().toString());
            return true;
        }else {
            return false;
        }
    }




}