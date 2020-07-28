package com.example.humaraGaon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class YourProfile extends AppCompatActivity {

    ImageView imageView,img;
    TextView textView,textViewName,textViewEmail;
    Button logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_profile);

        textView = findViewById(R.id.tv_tool);
        imageView = findViewById(R.id.iv_tool);

        img = findViewById(R.id.imageview);
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        logout = findViewById(R.id.btnlogout);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        Glide.with(this).load(user.getPhotoUrl()).into(img);
        textViewName.setText(user.getDisplayName());
        textViewEmail.setText(user.getEmail());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                Toast.makeText(YourProfile.this, "LogOut Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(YourProfile.this,LogInActivity.class));
            }
        });


        textView.setText("Your Profile");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YourProfile.this, Home.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,LogInActivity.class));
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

}
