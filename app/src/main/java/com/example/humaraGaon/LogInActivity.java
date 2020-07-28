package com.example.humaraGaon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.core.Tag;


public class LogInActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 234;

    private static final String TAG = "accountId";

    GoogleSignInClient mGoogleSignInClient;

    TextView textView, textViewfrgtpd;
    Button button,buttonguest;
    TextInputEditText emailedt, passedt;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        emailedt = findViewById(R.id.email_edt);
        passedt = findViewById(R.id.pass_edt);
        button = findViewById(R.id.btnlogin);
        textView = findViewById(R.id.tvregister);
        textViewfrgtpd=findViewById(R.id.frgtpswrd);
        buttonguest=findViewById(R.id.btnguest);

        firebaseAuth = FirebaseAuth.getInstance();

        buttonguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this,Home.class));
            }
        });



        //googleSignIn
        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("login Please Wait...");


        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("MyNotification", "MyNotification",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        //forgotpassword
        textViewfrgtpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetdialog= new AlertDialog.Builder(v.getContext());
                passwordResetdialog.setTitle("Reset Password?");
                passwordResetdialog.setMessage("Enter Your Email");
                passwordResetdialog.setView(resetMail);

                passwordResetdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the email and send reset link
                        String mail =resetMail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LogInActivity.this, "Reset Link Send to Your Email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LogInActivity.this, "Error ! Reset Link is Not Sent"+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //closing dialog
                    }
                });

                passwordResetdialog.create().show();
            }
        });//forgetpassword




        if (firebaseAuth.getCurrentUser() != null) {
            Intent intent = new Intent(LogInActivity.this, Home.class);
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, Registration.class);
                startActivity(intent);
            }
        });

        //alertdialog
        AlertDialog.Builder builder = new AlertDialog.Builder(LogInActivity.this);
        builder.setTitle("COVID-19");
        builder.setCancelable(false);
        builder.setMessage(" Government of India is" + " \n taking all necessary " + "\n steps to ensure that we " + "\n are prepared well to " +
       "\n face the challenge and" + " \n threat posed by the " + "\n growing pandemic of " + "\n COVID-19 the Corona Virus." +
       " \n With active support of " + "\n the people of India," + "\n we have been able to " + "\n contain the spread of the" +
       "\n Virus in our country." + "\nThe most important factor in" + "\n preventing the spread of" + "\n the Virus locally is to empower" +
      " \n the citizens with the right " + "\n information and taking precautions " + "\n as per the advisories " + "\n being issued by Ministry of " + "\n Health & Family Welfare.");
        builder.setPositiveButton("Got it", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    //googlesignin
    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseAuth.getCurrentUser() != null)
        {
            finish();
            startActivity(new Intent(LogInActivity.this,YourProfile.class));
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN)
        {
            //Getting the googleSignIn task
            Task<GoogleSignInAccount> task= GoogleSignIn.getSignedInAccountFromIntent(data);
            try
            {
                //google sign in was successfull, authentication with firebase
                GoogleSignInAccount account=task.getResult(ApiException.class);
                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e)
            {
                Toast.makeText(LogInActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct)
    {
        Log.d(TAG, "firebaseAuthWithGoogle:"+acct.getId());

        //getting the auth credential=like user id, Password
        AuthCredential credential= GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        //now using firebase we are signing in the user here
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Log.d(TAG,"signInWithCredential : Success");
                    //FirebaseUser user= mAuth.getCurrentUser();
                    startActivity(new Intent(LogInActivity.this,Home.class));
                    Toast.makeText(LogInActivity.this,"User Signed In",Toast.LENGTH_SHORT).show();

                }
                else {

                    //If sign in fails, display message to the user
                    Log.w(TAG, "SignInWithCredential : Failure",task.getException());
                    Toast.makeText(LogInActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void signIn()
    {
        Intent signinIntent =mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signinIntent,RC_SIGN_IN);
    }
    //goglesignin

    //login
    public void loginUser()
    {
        String email=emailedt.getText().toString().trim();//trim-remove space
        String password=passedt.getText().toString().trim();

        progressDialog.show();

        if(TextUtils.isEmpty(email))
        {
            emailedt.setError("User Field is Mandatory");
        }
        else if (TextUtils.isEmpty(password))
        {
            passedt.setError("Password field is mandotry");

        }
        else
        {
            firebaseAuth.signInWithEmailAndPassword(email,password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful())
                    {
                        Toast.makeText(LogInActivity.this, "User Signed in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogInActivity.this, Home.class));
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(LogInActivity.this, "Invalid ID or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(LogInActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
