package com.example.ohda499;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link catagorysearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class catagorysearch extends Fragment {
DatabaseReference ref;
ArrayList<masseges> list;
RecyclerView recyclerView;
SearchView searchView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public catagorysearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment catagorysearch.
     */
    // TODO: Rename and change types and number of parameters
    public static catagorysearch newInstance(String param1, String param2) {
        catagorysearch fragment = new catagorysearch();
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
    public void onStart() {
        super.onStart();
        if (ref!=null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists() ){
                        list=new ArrayList<>();
                        for(DataSnapshot ds : snapshot.getChildren()){
                        list.add(ds.getValue(masseges.class));
                        }
                        AdapterClass adapterClass=new AdapterClass(list);
                        recyclerView.setAdapter(adapterClass);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getActivity() ,error.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (searchView!=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {






                @Override
                public boolean onQueryTextSubmit(String query) {

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    if (s.length()==0) {
                        recyclerView.setVisibility(View.INVISIBLE);
                    }else {
                        recyclerView.setVisibility(View.VISIBLE);
                        search(s);
                    }

                    return true;
                }
            });
        }
    }

    private void search(String str){
        ArrayList<masseges> myLest = new ArrayList<>();
        for (masseges object : list){
            if (object.getFilename().toLowerCase().contains(str.toLowerCase())){

                myLest.add(object);
            }
        }


        AdapterClass adapterClass =new AdapterClass(myLest);
        recyclerView.setAdapter(adapterClass);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_catagorysearch, container, false);

        ref = FirebaseDatabase.getInstance().getReference().child("items");

        recyclerView =v.findViewById(R.id.rv);
        searchView = v.findViewById(R.id.searchView);






        return v;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchView:
                searchView.onActionViewExpanded();
                break;
        }
    }



}