package com.example.humaraGaon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);


        CardView cardView=(CardView) view.findViewById(R.id.card1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GraminBihar.class);
                startActivity(intent);
            }
        });
        /*TextView textView=(TextView) view.findViewById(R.id.textVgaon1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GraminBihar.class);
                startActivity(intent);
            }
        });*/

        CardView cardView2=(CardView) view.findViewById(R.id.card2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GraminBharat.class);
                startActivity(intent);
            }
        });

       /* TextView textViewtwo=(TextView) view.findViewById(R.id.textVgaon2);
        textViewtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GraminBharat.class);
                startActivity(intent);
            }
        });*/

        CardView cardView3=(CardView) view.findViewById(R.id.card3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GramBharWarshik.class);
                startActivity(intent);
            }
        });
        /*TextView textViewthree=(TextView) view.findViewById(R.id.textVgaon3);
        textViewthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GramBharWarshik.class);
                startActivity(intent);
            }
        });*/

        CardView cardView4=(CardView) view.findViewById(R.id.card4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Suchi.class);
                startActivity(intent);
            }
        });

        /*TextView textViewfour=(TextView) view.findViewById(R.id.textVgaon4);
        textViewfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Suchi.class);
                startActivity(intent);
            }
        });*/

        CardView cardView5=(CardView) view.findViewById(R.id.card5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GraminYojna.class);
                startActivity(intent);
            }
        });

       /* TextView textViewfive=(TextView) view.findViewById(R.id.textVgaon5);
        textViewfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GraminYojna.class);
                startActivity(intent);
            }
        });*/

        CardView cardView6=(CardView) view.findViewById(R.id.card6);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Jangannna.class);
                startActivity(intent);
            }
        });

       /* TextView textViewsix=(TextView) view.findViewById(R.id.textVgaon6);
        textViewsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Jangannna.class);
                startActivity(intent);
            }
        });*/

        CardView cardView7=(CardView) view.findViewById(R.id.card7);
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),RtiActivity.class);
                startActivity(intent);
            }
        });

        /*TextView textViewseven=(TextView) view.findViewById(R.id.textVgaon7);
        textViewseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),RtiActivity.class);
                startActivity(intent);
            }
        });*/

        CardView cardView8=(CardView) view.findViewById(R.id.card8);
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ComplainSuggestion.class);
                startActivity(intent);
            }
        });

        /*TextView textVieweight=(TextView) view.findViewById(R.id.textVgaon8);
        textVieweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ComplainSuggestion.class);
                startActivity(intent);
            }
        });*/

        return view;
    }
}
