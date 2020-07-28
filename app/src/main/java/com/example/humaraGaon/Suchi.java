package com.example.humaraGaon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Suchi extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    Button button1,button2,button3,button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suchi);

        textView=findViewById(R.id.tv_tool);
        imageView=findViewById(R.id.iv_tool);

        button1=findViewById(R.id.btn_nrega);
        button2=findViewById(R.id.btnrasnsuchi);
        button3=findViewById(R.id.btnAplBplSuchi);
        button4=findViewById(R.id.btnmatdatasuchi);


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matdatsuchi();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               aplbplsuchi();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rasnsuchi();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mnrega();
            }
        });



        textView.setText("Suchi");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Suchi.this,Home.class));
            }
        });

    }


    public void rasnsuchi()
    {
        Intent rasnsuchiIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://epds.bihar.gov.in/DistrictWiseRationCardDetailsBH.aspx"));
        startActivity(rasnsuchiIntent);
    }

    public void mnrega()
    {
        Intent mnregaIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nrega.nic.in/netnrega/homestciti.aspx?state_code=05&state_name=BIHAR&lflag=eng"));
        startActivity(mnregaIntent);
    }

    public void aplbplsuchi() {
        Intent matdasuchiIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bplcard.in/IN/BIHAR/"));
        startActivity(matdasuchiIntent);
    }

    public void matdatsuchi() {
        Intent matdasuchiIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sec.bihar.gov.in/SearchInFinalPdf.aspx"));
        startActivity(matdasuchiIntent);
    }

}
