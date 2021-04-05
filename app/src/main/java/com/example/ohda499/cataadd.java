package com.example.ohda499;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class cataadd extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST=1;
    private static final int PICK_IMAGE_REQUEST2=2;
    private static final int PICK_IMAGE_REQUEST3=3;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private  EditText editTextdes;
    private EditText fileNamelauout , type1;
    private ImageView mImageView, mImageView2,mImageView3;
    private ProgressBar mProgressBar;
    private String st1;
    private Uri mImageUri;
    private Uri mImageUri2;
    private Uri mImageUri3;
    private Spinner mspinner;
    Upload upload;
    private DatabaseReference root ;
    private DatabaseReference root2 ;
    private StorageReference reference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_cataadd);
        mButtonChooseImage = findViewById(R.id.button_choose_image);
        mButtonUpload = findViewById(R.id.button_upload);
        editTextdes = findViewById(R.id.editTextTextMultiLine);
        mImageView = findViewById(R.id.image_view);
        type1 = findViewById(R.id.addtype);
        mProgressBar = findViewById(R.id.progress_bar);
        fileNamelauout = findViewById(R.id.fileName);
        mProgressBar.setVisibility(View.INVISIBLE);

        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gall = new Intent();
                gall.setAction(Intent.ACTION_GET_CONTENT);
                gall.setType("image/*");
                startActivityForResult(gall,2);

            }
        });

        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mImageUri !=null){
                    uploadeTofirbase(mImageUri);
                    Intent intent = new Intent(cataadd.this,homebage.class);
           startActivity(intent);
                }else{
                    Toast.makeText(cataadd.this, "please Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 2 && resultCode == Activity.RESULT_OK && data !=null  ){
            mImageUri = data.getData();
            mImageView.setImageURI(mImageUri);

        }
    }
    private void uploadeTofirbase(Uri uri){

        st1 =getIntent().getStringExtra("phone");


        root = FirebaseDatabase.getInstance().getReference("items");
        reference = FirebaseStorage.getInstance().getReference();
        final StorageReference fileRef = reference.child(System.currentTimeMillis() + "." + getFileExtension(uri));
        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String descrabtion = editTextdes.getEditableText().toString().trim();
                        String filname = fileNamelauout.getEditableText().toString().trim();
                        String userAdress = type1.getEditableText().toString().trim();
                        //   Upload upload = new Upload(uri.toString(),descrabtion,filname);

                        String typ =getIntent().getStringExtra("2");

                        System.out.println(st1);
                        System.out.println("--------------------");
                       try {
                           upload = new Upload(uri.toString(),descrabtion,filname,st1,userAdress,typ);
                           root.child(st1).setValue(upload);
                           mProgressBar.setVisibility(View.INVISIBLE);
                           Toast.makeText(cataadd.this, "Uploaded Successfully ", Toast.LENGTH_SHORT).show();
                       }catch (Exception e){
                           Toast.makeText(cataadd.this, "You just added items please delete that item if you want to add another ", Toast.LENGTH_SHORT).show();
                       }



                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mProgressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(cataadd.this, "Uploading Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private String getFileExtension(Uri muri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();

        return  mime.getExtensionFromMimeType(cr.getType(muri));
    }

}