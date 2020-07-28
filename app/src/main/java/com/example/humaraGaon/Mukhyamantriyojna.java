package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Mukhyamantriyojna extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button btnPariwahan,btnkanyauthan,btnUdhamiyojna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mukhyamantriyojna);


        textView=findViewById(R.id.tv_tool);
        imageView=findViewById(R.id.iv_tool);

        btnPariwahan=findViewById(R.id.mukyojna1);
        btnkanyauthan=findViewById(R.id.mukyojna2);
        btnUdhamiyojna=findViewById(R.id.mukyojna3);

        btnUdhamiyojna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mukhyamantriyojna.this,MukhyamantriUdhamiYojna.class));
            }
        });

        btnkanyauthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mukhyamantriyojna.this,KanyaUthanYojna.class));
            }
        });


        btnPariwahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mukhyamantriyojna.this,GramPariwahanyojna.class));
            }
        });


        textView.setText("MukhyaMantri Yojna");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mukhyamantriyojna.this,GraminYojna.class));
            }
        });
    }
}
