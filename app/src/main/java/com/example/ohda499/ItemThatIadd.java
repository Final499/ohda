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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
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

       ph =getIntent().getStringExtra("phone");
        System.out.println(ph);
        recyclerView = (RecyclerView)findViewById(R.id.recv);
         databaseReference = FirebaseDatabase.getInstance().getReference().child("items");

        options = new FirebaseRecyclerOptions.Builder<masseges>().setQuery(databaseReference,masseges.class).build();
        adapter = new FirebaseRecyclerAdapter<masseges, myAdabter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull myAdabter holder, int position, @NonNull masseges model) {
                Query check = databaseReference.orderByChild("phoneid").equalTo("ph");
                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.exists()) {
                            Picasso.get().load(model.getmImageUrl()).into(holder.i1, new Callback() {
                                @Override
                                public void onSuccess() {

                                }

                                @Override
                                public void onError(Exception e) {
                                    Toast.makeText(ItemThatIadd.this.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                                }
                            });


                            holder.filename.setText(model.getFilename());
                            holder.userAdress.setText(model.getUserAdress());
                            holder.type2.setText(model.getType2());

                        }else {
                            Toast.makeText(ItemThatIadd.this.getApplicationContext(), "no Item ", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ItemThatIadd.this, error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });




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