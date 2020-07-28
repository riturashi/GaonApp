package com.example.humaraGaon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Registration extends AppCompatActivity {

    TextView textViewgolgn;
    TextInputEditText textInputEditText2,textInputEditText3;
    Button button;
    FirebaseAuth mfirebaseAuth;
    ProgressDialog mprogressDialog;

    //uploadimage
    CircleImageView circleImageView;
    Button buttonpick,buttonupld;
    Uri filepath;
    FirebaseStorage firebaseStorage;//parent(like it is database)
    StorageReference storageReference;//child(it is table)
    StorageTask storageTask;// with the help of storagetask we upload image(it is column)
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textInputEditText2=findViewById(R.id.editxt1);
       textInputEditText3=findViewById(R.id.editxt2);
        button=findViewById(R.id.btnregister);
        textViewgolgn=findViewById(R.id.haveaccount);

        //imageupld
        circleImageView=findViewById(R.id.profile_image);
        buttonpick=findViewById(R.id.pick);
        buttonupld=findViewById(R.id.upld);


        firebaseStorage=FirebaseStorage.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        buttonpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),123);
            }
        });

        buttonupld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(filepath !=null)
                {
                    final ProgressDialog progressDialog=new ProgressDialog(Registration.this);
                    progressDialog.setTitle("Uploading");
                    progressDialog.show();
                    StorageReference storeref=storageReference.child("image/pic.jpg"+i);
                    storageTask=storeref.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            i++;
                            Toast.makeText(Registration.this, "uploaded", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                            progressDialog.setMessage("Uploading "+((int)progress)+"%...");

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Registration.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });//imgupld

        mfirebaseAuth=FirebaseAuth.getInstance();
        mprogressDialog=new ProgressDialog(this);
        mprogressDialog.setMessage("Register please wait?????");



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        });



        textViewgolgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,LogInActivity.class));
            }
        });
    }


    private void registeruser()
    {
        String email= textInputEditText2.getText().toString().trim();
        String password= textInputEditText3.getText().toString().trim();

        mprogressDialog.show();

        if(TextUtils.isEmpty(email))
        {
            textInputEditText2.setError("Please Enter EmailID");
        }
        else if (TextUtils.isEmpty(password))
        {
            textInputEditText3.setError("Enter Password");

        }
        else
        {
            mfirebaseAuth.createUserWithEmailAndPassword(email,password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        mprogressDialog.dismiss();
                        Toast.makeText(Registration.this, "user Sgned in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Registration.this,Home.class));
                    }
                    else
                    {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException)
                        {
                            mprogressDialog.dismiss();
                            Toast.makeText(Registration.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    mprogressDialog.dismiss();
                    Toast.makeText(Registration.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

//imgupld
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 123 && resultCode == RESULT_OK && data!=null && data.getData() != null)
        {
            filepath = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                circleImageView.setImageBitmap(bitmap);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }//imgupld



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        startActivity(new Intent(Registration.this,LogInActivity.class));
    }
}