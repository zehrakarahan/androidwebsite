package com.example.myapplication;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    String name,mail;
    Uri photoUrl;
    boolean emailVerified;
    String uid;
    EditText etMail,etPassword;
    Button btngiris,btnkayit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // etMail=(EditText)findViewById(R.id.uyeadi);
      //  etPassword=(EditText)findViewById(R.id.uyesifre);
       // baslangic();
       // girisYap(etMail.getText().toString(),etPassword.getText().toString());

    }

}
