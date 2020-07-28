package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GraminYojna extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    TextView textViewy1,textViewy2,textViewy3,textViewy4;
    Button buttonprdh,buttonmukhya,buttonsauchalya,buttonswach,buttonujwal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramin_yojna);



        textView=findViewById(R.id.tv_tool);
        imageView=findViewById(R.id.iv_tool);


        buttonmukhya=findViewById(R.id.btnmukhymntri);

        buttonmukhya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GraminYojna.this,Mukhyamantriyojna.class));
            }
        });


        textView.setText("Gramin Yojna");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GraminYojna.this,Home.class));
            }
        });

    }
}
