package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AplBplSuchi extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apl_bpl_suchi);

        imageView=findViewById(R.id.iv_tool);
        textView=findViewById(R.id.tv_tool);

        textView.setText("APL/BPL Suchi");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AplBplSuchi.this,Suchi.class));

            }
        });
    }
}
