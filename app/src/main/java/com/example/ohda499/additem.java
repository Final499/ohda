package com.example.ohda499;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link additem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class  additem extends Fragment {

    private Button sport , farming ,electronics,Carpentry,plumbing,furniture,kitchen_utensil,camping,cars, medical_miscellaneous, animal_supplies,others;


    private Button donate , len;
    String st1 , st2;

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

        donate = v.findViewById(R.id.button2);
        len = v.findViewById(R.id.button3);
        Intent in = getActivity().getIntent();
        st1 =in.getStringExtra("phone");





        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query ch = FirebaseDatabase.getInstance().getReference("items").orderByChild("phoneid").equalTo(st1);
                ch.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            Toast.makeText(getActivity(), "you already added item please delete it before adding another one", Toast.LENGTH_LONG).show();

                        }else{
                            Intent in = getActivity().getIntent();
                            st1 =in.getStringExtra("phone");

                            Intent intent = new Intent(getActivity(),cataadd.class);
                            intent.putExtra("phone",st1);
                            String tt="Donate";
                            intent.putExtra("2",tt);

                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        len.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query ch = FirebaseDatabase.getInstance().getReference("items").orderByChild("phoneid").equalTo(st1);
                ch.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            Toast.makeText(getActivity(), "you already added item please delete it before adding another one", Toast.LENGTH_LONG).show();

                        }else{
                            Intent in = getActivity().getIntent();
                            st1 =in.getStringExtra("phone");
                            Intent intent = new Intent(getActivity(),cataadd.class);
                            String tt="Lend";
                            intent.putExtra("2",tt);
                            intent.putExtra("phone",st1);

                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });




    //    mStorage = FirebaseStorage.getInstance().getReference("users").child(st1);
      //  mdatabaseref = FirebaseDatabase.getInstance().getReference("users").child(st1);

return v;
    }


}