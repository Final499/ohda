package com.example.ohda499;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ItemThatIadd extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<masseges> options;
    FirebaseRecyclerAdapter<masseges,myAdabter> adapter;
    String ph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_that_iadd);
        Intent intent= getIntent();
        ph=intent.getStringExtra("phone");
        recyclerView = (RecyclerView)findViewById(R.id.recv);
         databaseReference = FirebaseDatabase.getInstance().getReference().child("items");
        options = new FirebaseRecyclerOptions.Builder<masseges>().setQuery(databaseReference,masseges.class).build();
        adapter = new FirebaseRecyclerAdapter<masseges, myAdabter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull myAdabter holder, int position, @NonNull masseges model) {
                Picasso.get().load(model.getmImageUrl()).into(holder.i1, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });



                holder.filename.setText(model.getFilename());
                holder.userAdress.setText(model.getUserAdress());



            }

            @NonNull
            @Override
            public myAdabter onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.masseg_item,parent,false);

                return new myAdabter(view);
            }
        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ItemThatIadd.this.getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onStart() {
        super.onStart();
        if (adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        if (adapter!=null)
            adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null)
            adapter.startListening();

    }
}