package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ComplainSuggestion extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button buttoncl,btnemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_suggestion);


        final String[] TO = {"someone@gmail.com"};

        textView = findViewById(R.id.tv_tool);
        imageView = findViewById(R.id.iv_tool);


        buttoncl=findViewById(R.id.btncl);
        btnemail=findViewById(R.id.btnemail);


        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shrintent=new Intent();
                shrintent.setAction(Intent.ACTION_SEND);
                shrintent.putExtra(Intent.EXTRA_EMAIL,"Email");
                shrintent.setType("text/plain");
                startActivity(Intent.createChooser(shrintent,"share via"));
            }
        });


        buttoncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Uri uri=Uri.parse("tel:06122219545");
               Intent intent=new Intent(Intent.ACTION_DIAL,uri);
               startActivity(intent);
            }
        });



        textView.setText("Complain/Suggestion");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComplainSuggestion.this, Home.class));
            }
        });

    }
}
