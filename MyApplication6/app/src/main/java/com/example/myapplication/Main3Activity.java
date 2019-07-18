package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main3Activity extends AppCompatActivity{
    EditText etMail,etPassword;
    Button btnGiris;
    private TextView logintoRegister;
    private ProgressDialog registerProgress;
    private FirebaseAuth mAuth;
    String name,mail,uid ;
    Uri photoUrl;
    boolean emailVerified;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        etMail=(EditText)findViewById(R.id.login_email);
        etPassword=(EditText)findViewById(R.id.loginpassword);
        btnGiris=(Button)findViewById(R.id.hazirlama);
        logintoRegister = (TextView) findViewById(R.id.login_need_account);
        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitol(etMail.getText().toString(),etPassword.getText().toString());
            }
        });
        registerProgress = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        logintoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this, LoginKaydi.class);
                startActivity(i);
            }
        });

    }
    public void kayitol(String email,String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Name, email address, and profile photo Url
                                 name = user.getDisplayName();
                                mail = user.getEmail();
                                photoUrl = user.getPhotoUrl();

                                // Check if user's email is verified
                                emailVerified = user.isEmailVerified();

                                // The user's ID, unique to the Firebase project. Do NOT use this value to
                                // authenticate with your backend server, if you have one. Use
                                // FirebaseUser.getIdToken() instead.
                                uid = user.getUid();
                            }
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Main3Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
    public void girisyap(String email,String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                // Name, email address, and profile photo Url
                                 name = user.getDisplayName();
                                mail = user.getEmail();
                                 photoUrl = user.getPhotoUrl();

                                // Check if user's email is verified
                                 emailVerified = user.isEmailVerified();

                                // The user's ID, unique to the Firebase project. Do NOT use this value to
                                // authenticate with your backend server, if you have one. Use
                                // FirebaseUser.getIdToken() instead.
                                 uid = user.getUid();
                            }
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Main3Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);
    }
        /*loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=loginEmail.getText().toString();
                String sifre=loginPassword.getText().toString();
                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(sifre))
                {
                registerProgress.setTitle("Oturum Aciliyor...");
                registerProgress.setMessage("Hesabınıza Giriş Yapılıyo Lütfen Bekleyiniz...");
                registerProgress.setCanceledOnTouchOutside(false);
                registerProgress.show();
                login_user(email,sifre);
                }
            }
        });
    }*/
   /* private void login_user(String email,String sifre)
    {
    mAuth.createUserWithEmailAndPassword(email,sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
          if(task.isSuccessful())
          {
              registerProgress.dismiss();
              Intent gecis=new Intent(Main3Activity.this,Anasayfa.class);
              startActivity(gecis);

          }
          else
          {
              Toast.makeText(Main3Activity.this,"Giriş Yapılamadı!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
          }
         }
     });
    }
*/

  /*  @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);
    }*/
}
