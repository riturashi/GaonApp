package com.example.humaraGaon;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Activity obj;
    int res;
    ArrayList<DataModel> arrayList=new ArrayList<>();

    MyAdapter(Activity obj,int res,ArrayList<DataModel> arrayList)
    {
        this.obj=obj;
        this.res=res;
        this.arrayList=arrayList;
    }


    @Override
    public MyAdapter.MyHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(obj).inflate(res,parent,false);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyHolder holder, int position) {

        DataModel d=arrayList.get(position);
        holder.tv1.setText(d.getName());
        holder.tv3.setText(d.getOccupation());
        holder.tv2.setText(d.getContact());
        holder.tv4.setText(d.getDistrict());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2,tv3,tv4;

        public MyHolder(View itemView) {
            super(itemView);

            tv1=itemView.findViewById(R.id.tv_name);
            tv3=itemView.findViewById(R.id.tv_occupation);
            tv2=itemView.findViewById(R.id.tv_contact);
            tv4=itemView.findViewById(R.id.tv_district);
        }
    }
}
