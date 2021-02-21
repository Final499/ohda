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
    private static final int PICK_IMAGE_REQUEST=1;
    private static final int PICK_IMAGE_REQUEST2=2;
    private static final int PICK_IMAGE_REQUEST3=3;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private  EditText editTextdes;
    private EditText fileNamelauout;
    private ImageView mImageView, mImageView2,mImageView3;
    private ProgressBar mProgressBar;
    private String st1;
    private Uri mImageUri;
    private Uri mImageUri2;
    private Uri mImageUri3;
    private Spinner mspinner;


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
        mButtonChooseImage = v.findViewById(R.id.button_choose_image);
        mButtonUpload = v.findViewById(R.id.button_upload);
        editTextdes = v.findViewById(R.id.editTextTextMultiLine);
        mTextViewShowUploads = v.findViewById(R.id.text_view_show_uploads);
        mImageView = v.findViewById(R.id.image_view);
        mImageView2 = v.findViewById(R.id.image_view2);
        mImageView3 = v.findViewById(R.id.image_view3);
        mProgressBar = v.findViewById(R.id.progress_bar);
        fileNamelauout = v.findViewById(R.id.fileName);
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

                }else{
                    Toast.makeText(getActivity(), "Pleas Select Image", Toast.LENGTH_SHORT).show();
                }
            }
        });


    //    mStorage = FirebaseStorage.getInstance().getReference("users").child(st1);
      //  mdatabaseref = FirebaseDatabase.getInstance().getReference("users").child(st1);

return v;
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
        Intent in = getActivity().getIntent();
        st1 =in.getStringExtra("phone");

        root = FirebaseDatabase.getInstance().getReference("users").child(st1);
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
                        Upload upload = new Upload(uri.toString(),descrabtion,filname);
                        //generat key
                        String uplodId = root.push().getKey();
                        root.child(uplodId).setValue(upload);
                        mProgressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getActivity(), "Uploaded Successfully ", Toast.LENGTH_SHORT).show();


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
                Toast.makeText(getActivity(), "Uploading Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private String getFileExtension(Uri muri){
        ContentResolver cr = getActivity().getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();

        return  mime.getExtensionFromMimeType(cr.getType(muri));
    }


}