package com.example.ohda499;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link additem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class additem extends Fragment {

    private Button sport , farming ,electronics,Carpentry,Plumber,furniture,cooking,Trips,cars,medical,Animals,others;

String  st1;

    private DatabaseReference root ;
    private StorageReference reference ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public additem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment additem.
     */
    // TODO: Rename and change types and number of parameters
    public static additem newInstance(String param1, String param2) {
        additem fragment = new additem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View v = inflater.inflate(R.layout.fragment_additem, container, false);

        sport = v.findViewById(R.id.Sp);
        farming = v.findViewById(R.id.Fa);
        electronics = v.findViewById(R.id.button6);
        Carpentry = v.findViewById(R.id.button7);
        Plumber = v.findViewById(R.id.button8);
        furniture = v.findViewById(R.id.button9);
        cooking = v.findViewById(R.id.button10);
        Trips = v.findViewById(R.id.button11);
        cars = v.findViewById(R.id.button12);
        medical = v.findViewById(R.id.button13);
        Animals = v.findViewById(R.id.button14);
        others = v.findViewById(R.id.button15);

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Sport";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });
        farming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Farming";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });
        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Electronics";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });
        Carpentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Carpentry";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });
        Plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Plumber";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });
        furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Furniture";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });  cooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Cooking";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });  Trips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Trips";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });  cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Cars";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });  medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Medical";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });  Animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Animals";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });  others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = getActivity().getIntent();
                st1 =in.getStringExtra("phone");
                Intent intent = new Intent(getActivity(),cataadd.class);
                intent.putExtra("phone",st1);
                String spo="Others";
                intent.putExtra("1",spo);
                startActivity(intent);
            }
        });




    //    mStorage = FirebaseStorage.getInstance().getReference("users").child(st1);
      //  mdatabaseref = FirebaseDatabase.getInstance().getReference("users").child(st1);

return v;
    }


}