package com.example.humaraGaon;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    NotificationManager notificationManager;
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment fragment;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


       firebaseAuth=firebaseAuth.getInstance();
       progressDialog=new ProgressDialog(this);
       progressDialog.setMessage("logout");

        notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        drawer=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);


        //drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        //fragment
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        ft.replace(R.id.fragmentv, homeFragment);
        ft.commit();

    }

    //navigation
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        try {
            fragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.nav_about:
                    fragment = new AboutGFragment();
                    break;

                case R.id.nav_privacy:
                    fragment=new PrivacyFragment();
                    break;

                case R.id.nav_share:
                    Intent shrintent=new Intent();
                    shrintent.setAction(Intent.ACTION_SEND);
                    shrintent.putExtra(Intent.EXTRA_TEXT,"https://www.youtube.com/");
                    shrintent.setType("text/plain");
                    startActivity(Intent.createChooser(shrintent,"share via"));
                    break;

                case R.id.nav_profile:
                    startActivity(new Intent(Home.this,YourProfile.class));
                    break;

                case R.id.nav_exit:
                    AlertDialog.Builder builder=new AlertDialog.Builder(Home.this);
                    builder.setTitle("Exit");
                    builder.setCancelable(false);
                    builder.setMessage("Sure You want to exit?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });
                    builder.show();
                    break;

            }
        }catch (Exception e){

        }
        //fragment code to add fragment
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragmentv, fragment).commit();
        }
        drawer.closeDrawers();//close drawer
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout)
        {
           progressDialog.show();
           firebaseAuth.signOut();
           //item.setVisibility(View.INVISIBLE);
           startActivity(new Intent(Home.this,LogInActivity.class));
            Toast.makeText(this, "LogOut", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

            return super.onOptionsItemSelected(item);
    }

}
