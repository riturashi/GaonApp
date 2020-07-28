package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GramPariwahanyojna extends AppCompatActivity {
    ImageView imageView,imageView2;
    TextView textView,textView2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gram_pariwahanyojna);

        textView=findViewById(R.id.tv_tool);
        imageView=findViewById(R.id.iv_tool);

        textView2=findViewById(R.id.tv1);
        imageView2=findViewById(R.id.iv1);


        button=findViewById(R.id.btnpariwahan);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://164.100.37.26/MMGPY/Account/Login.aspx"));
                startActivity(intent);
            }
        });

        textView.setText("GramPariwahan Yojna");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GramPariwahanyojna.this,Mukhyamantriyojna.class));
            }
        });



    }
}
