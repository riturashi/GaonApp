package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class GraminBihar extends AppCompatActivity {
    ImageView imageView;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramin_bihar);

        imageView=findViewById(R.id.iv_tool);
        textView=findViewById(R.id.tv_tool);

        textView.setText("Gramin Bihar");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GraminBihar.this,Home.class));
            }
        });

    }
}
