package com.example.ohda499;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link additem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class additem extends Fragment {

    private Button sport , farming ,electronics,Carpentry,plumbing,furniture,kitchen_utensil,camping,cars, medical_miscellaneous, animal_supplies,others;

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

        sport = v.findViewById(R.id.sportsb);
        farming = v.findViewById(R.id.farmingb);
        electronics = v.findViewById(R.id.electronicsb);
        Carpentry = v.findViewById(R.id.carpentryb);
        plumbing = v.findViewById(R.id.plumbingb);
        furniture = v.findViewById(R.id.furnitureb);
        kitchen_utensil = v.findViewById(R.id.kitchen_utensilb);
        camping = v.findViewById(R.id.campingb);
        cars = v.findViewById(R.id.carb);
        medical_miscellaneous = v.findViewById(R.id.medical_miscellaneousb);
        animal_supplies = v.findViewById(R.id.animal_suppliesb);
        others = v.findViewById(R.id.othersb);

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
        plumbing.setOnClickListener(new View.OnClickListener() {
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
        });  kitchen_utensil.setOnClickListener(new View.OnClickListener() {
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
        });  camping.setOnClickListener(new View.OnClickListener() {
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
        });  medical_miscellaneous.setOnClickListener(new View.OnClickListener() {
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
        });  animal_supplies.setOnClickListener(new View.OnClickListener() {
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