package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class LoginKaydi extends AppCompatActivity  {

    private FirebaseAuth mAuth;

    private EditText registerName;
    private EditText registerEmail;
    private EditText registerPassword;
    private TextView register_to_Login;
    private Button registerButton;
    private ProgressDialog registerProgress;
    //private ProgressDialog registerProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_kayitli_olmayan);
        registerButton = (Button) findViewById(R.id.register_btn);
        registerName = (EditText) findViewById(R.id.register_adi);
        registerEmail = (EditText) findViewById(R.id.register_mail);
        registerPassword = (EditText) findViewById(R.id.register_sifre);
        register_to_Login = (TextView) findViewById(R.id.register_need);
        registerProgress = new ProgressDialog(this);
        //registerProgress=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        register_to_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginKaydi.this, Main3Activity.class);
                startActivity(loginIntent);
            }
        });
        mAuth.createUserWithEmailAndPassword("", "")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginKaydi.this, "Authentication failed.",
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



}
