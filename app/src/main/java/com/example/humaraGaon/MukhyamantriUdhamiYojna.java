package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MukhyamantriUdhamiYojna extends AppCompatActivity {
    ImageView imageView,iv1,iv2,iv3,iv4,iv5;
    TextView textView,txtv1,txtv2;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mukhyamantri_udhami_yojna);

        textView=findViewById(R.id.tv_tool);
        imageView=findViewById(R.id.iv_tool);

        txtv1=findViewById(R.id.textview1);
        txtv2=findViewById(R.id.textview2);
        iv1=findViewById(R.id.imageview);
        iv1=findViewById(R.id.imageview2);
        iv1=findViewById(R.id.imageview3);
        iv1=findViewById(R.id.imageview4);
        iv1=findViewById(R.id.imageview5);

        button1=findViewById(R.id.btnudhmi1);
        button2=findViewById(R.id.btnudhmi2);



        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel=new NotificationChannel("MyNotification", "MyNotification",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.startup.bihar.gov.in/CMSCSTUDYAMI/OTP.aspx"));
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.startup.bihar.gov.in/CMSCSTUDYAMI/Default.aspx"));
                startActivity(intent2);
            }
        });

        textView.setText("Mukhyamantri Udhami Yojna");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MukhyamantriUdhamiYojna.this,GraminYojna.class));
            }
        });

    }
}
