package com.example.ohda499;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class type extends AppCompatActivity {
    private Button bor , len;
    String st1 , st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        bor = findViewById(R.id.button2);
        len = findViewById(R.id.button3);
        Intent in = getIntent();
        st1 =in.getStringExtra("phone");
        String catagory =getIntent().getStringExtra("1");

        switch (catagory){
            case "Sport":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Sport";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Sport";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                break;
            case "Farming":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Farming";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Farming";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
            case "Electronics":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Electronics";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Electronics";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
            case "Carpentry":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Carpentry";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Donate";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Carpentry";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
            case "Plumber":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Plumber";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Plumber";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });


                break;
            case "Furniture":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Furniture";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Furniture";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });


                break;
            case "Cooking":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Cooking";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Cooking";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });


                break;
            case "Trips":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Trips";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Trips";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
            case "Cars":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Cars";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Cars";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
            case "Medical":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Medical";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Medical";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
            case "Animals":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Animals";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Animals";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
            case "Others":
                bor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");

                        Intent intent = new Intent(type.this,cataadd.class);
                        intent.putExtra("phone",st1);
                        String tt="Donate";
                        intent.putExtra("2",tt);

                        String spo="Others";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });
                len.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = getIntent();
                        st1 =in.getStringExtra("phone");
                        Intent intent = new Intent(type.this,cataadd.class);
                        String tt="Lend";
                        intent.putExtra("2",tt);
                        intent.putExtra("phone",st1);
                        String spo="Others";
                        intent.putExtra("1",spo);
                        startActivity(intent);
                    }
                });

                break;
        }



    }
}