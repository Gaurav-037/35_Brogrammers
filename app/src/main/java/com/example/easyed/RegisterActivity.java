package com.example.easyed;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText rEmail, rPassword, rName;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.signupbtn);
        textView = findViewById(R.id.textView3);
        rEmail = findViewById(R.id.Lgmail);
        rName = findViewById(R.id.Lname);
        rPassword = findViewById(R.id.Lpassword);
        progressBar= findViewById(R.id.progressBar2);
        firebaseAuth = FirebaseAuth.getInstance();


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOne = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentOne);
                finish();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = rEmail.getText().toString().trim();
                String Password = rPassword.getText().toString().trim();
                String Name = rName.getText().toString().trim();


                if (TextUtils.isEmpty(Email)) {
                    rEmail.setError("Cannot be empty");
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    rPassword.setError("Cannot be empty");
                    return;
                }
                if (Password.length()<8){
                    rPassword.setError("Must be greater than 8");
                }
                if (TextUtils.isEmpty(Name)){
                    rName.setError("Cannot be empty");
                }

                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, SelectActivity.class));
                            finish();
                            progressBar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        progressBar.setVisibility(View.GONE);

                    }

                });
            }

        });

    }
}