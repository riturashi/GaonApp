package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RtiNextActivity extends AppCompatActivity {
    TextView textView2;

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rti_next);


        textView = findViewById(R.id.tv_tool);
        imageView = findViewById(R.id.iv_tool);

        textView.setText("RTI Informaition");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RtiNextActivity.this, RtiActivity.class));
            }
        });

        textView2=findViewById(R.id.nxt_txt);

        String t=getIntent().getStringExtra("key");
        textView2.setText(t);
    }
}
