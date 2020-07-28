package com.example.humaraGaon;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class AnotherJAva implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if(position == 0)
        {
            Toast.makeText(parent.getContext(), "Please select", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String sText=parent.getItemAtPosition(position).toString();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
