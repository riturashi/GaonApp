package com.example.humaraGaon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RtiActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    ListView listView;
    DatabaseReference databaseReference;
    List<String> title_list,rtiinfo_list;
    ArrayAdapter<String> adapter;
    RtiInformation rtiInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rti);

        textView = findViewById(R.id.tv_tool);
        imageView = findViewById(R.id.iv_tool);

            listView=findViewById(R.id.listview);
            databaseReference= FirebaseDatabase.getInstance().getReference("rti");
            rtiInformation = new RtiInformation();
            title_list=new ArrayList<>();
            rtiinfo_list=new ArrayList<>();
            adapter=new ArrayAdapter<>(this,R.layout.item,R.id.item_txt,title_list);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    title_list.clear();
                    rtiinfo_list.clear();

                    for(DataSnapshot ds: dataSnapshot.getChildren())
                    {
                        rtiInformation=ds.getValue(RtiInformation.class);
                        if (rtiInformation != null) {
                            title_list.add(rtiInformation.getTitle());
                        }
                        if (rtiInformation != null) {
                            rtiinfo_list.add(rtiInformation.getRtiinfo());
                        }
                    }

                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent3=new Intent(RtiActivity.this,RtiNextActivity.class);
                            String p=rtiinfo_list.get(position);
                            intent3.putExtra("key",p);
                            startActivity(intent3);
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


            textView.setText("RTI");

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RtiActivity.this, Home.class));
                }
            });
        }
    }

