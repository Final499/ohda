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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.sql.SQLOutput;

public class ItemThatIadd extends AppCompatActivity {
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    RecyclerView recyclerView;
    FirebaseAuth fAuth;
    FirebaseUser user ;
    String ph;
    Button DELE;
    ImageView g;
    TextView add , na,ty;
    TextView add1 , na1,ty1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_item_that_iadd);
        DELE= findViewById(R.id.button4);
        g= findViewById(R.id.imageviewg);
        add= findViewById(R.id.adress);
        na= findViewById(R.id.namef);
        ty= findViewById(R.id.textView9);
        add1= findViewById(R.id.textView2);
        na1= findViewById(R.id.textView3);
        ty1= findViewById(R.id.textView8);

       ph =getIntent().getStringExtra("phone");
       user = FirebaseAuth.getInstance().getCurrentUser();
        System.out.println(user);

      //  recyclerView = (RecyclerView)findViewById(R.id.recv);
       //  databaseReference =  FirebaseDatabase.getInstance().getReference("items");
       //  databaseReference2 = (DatabaseReference) FirebaseDatabase.getInstance().getReference("items").orderByChild("phoneid").equalTo(ph);
        Query check = FirebaseDatabase.getInstance().getReference("items").orderByChild("phoneid").equalTo(ph);
       // options = new FirebaseRecyclerOptions.Builder<masseges>().setQuery(databaseReference,masseges.class).build();





                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                     if(snapshot.exists()) {
                         na1.setVisibility(View.VISIBLE);
                         ty1.setVisibility(View.VISIBLE);
                         add1.setVisibility(View.VISIBLE);
                         DELE.setVisibility(View.VISIBLE);
                        String type = snapshot.child(ph).child("type2").getValue(String.class);
                        String name = snapshot.child(ph).child("filename").getValue(String.class);
                        String addre = snapshot.child(ph).child("userAdress").getValue(String.class);
                        String image = snapshot.child(ph).child("mImageUrl").getValue(String.class);


                              Picasso.get().load(image).into(g, new Callback() {
                                 @Override
                                public void onSuccess() {

                                }

                                 @Override
                                 public void onError(Exception e) {
                                    Toast.makeText(ItemThatIadd.this.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                                }
                             });
                         add.setText(addre);
                         na.setText(name);
                         ty.setText(type);

                         DELE.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 DatabaseReference ref = FirebaseDatabase.getInstance().getReference("items").child(ph);
                                 ref.removeValue();
                                 Intent in = new Intent(ItemThatIadd.this,homebage.class);
                                 startActivity(in);
                             }
                         });



                         }else{




                         g.setVisibility(View.INVISIBLE);

                         Toast.makeText(ItemThatIadd.this.getApplicationContext(), "no Item ", Toast.LENGTH_LONG).show();

                     }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(ItemThatIadd.this, error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });







    }
}