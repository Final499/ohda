package com.example.ohda499;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class add_item extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST=1;
    private static final int PICK_IMAGE_REQUEST2=2;
    private static final int PICK_IMAGE_REQUEST3=3;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextFileName;
    private ImageView mImageView, mImageView2,mImageView3;
    private ProgressBar mProgressBar;

    private Uri mImageUri;
    private Uri mImageUri2;
    private Uri mImageUri3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        mButtonChooseImage = findViewById(R.id.button_choose_image);
        mButtonUpload = findViewById(R.id.button_upload);
        mTextViewShowUploads = findViewById(R.id.text_view_show_uploads);
        mEditTextFileName = findViewById(R.id.edit_text_file_name);
        mImageView = findViewById(R.id.image_view);
        mImageView2 = findViewById(R.id.image_view2);
        mImageView3 = findViewById(R.id.image_view3);
        mProgressBar = findViewById(R.id.progress_bar);


        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mTextViewShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    private void openFileChooser() {
        Intent intent = new Intent();
        Intent intent2 = new Intent();
        Intent intent3 = new Intent();
        intent.setType("image/*");intent2.setType("image/*");intent3.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);intent2.setAction(Intent.ACTION_GET_CONTENT);intent3.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
        startActivityForResult(intent2, PICK_IMAGE_REQUEST2);
        startActivityForResult(intent3, PICK_IMAGE_REQUEST3);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            mImageView.setImageURI(mImageUri);

        }else if (requestCode == PICK_IMAGE_REQUEST2 && resultCode == RESULT_OK
                && data != null && data.getData() != null){
            mImageUri2 = data.getData();
            mImageView2.setImageURI(mImageUri2);
        }
        else if (requestCode == PICK_IMAGE_REQUEST3 && resultCode == RESULT_OK
                && data != null && data.getData() != null){
            mImageUri3 = data.getData();
            mImageView3.setImageURI(mImageUri3);}
    }
}