package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class KanyaUthanYojna extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanya_uthan_yojna);

        textView=findViewById(R.id.tv_tool);
        imageView=findViewById(R.id.iv_tool);


        textView.setText("KanyaUthan Yojna");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KanyaUthanYojna.this,GraminYojna.class));
            }
        });
    }
}
