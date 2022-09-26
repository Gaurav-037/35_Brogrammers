package com.example.easyed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText iEmail, iPassword;
    ProgressBar iProgressBar;
    FirebaseAuth iFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iEmail= findViewById(R.id.Lgmail);
        iPassword= findViewById(R.id.Lpassword);
        iFirebaseAuth= FirebaseAuth.getInstance();
        iProgressBar= findViewById(R.id.progressBar);


        button= findViewById(R.id.signInButton);
        textView= findViewById(R.id.textView3);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOne= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentOne);
            }
        });

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                String Email=iEmail.getText().toString().trim();
                String Password= iPassword.getText().toString().trim();

                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)){
                    iEmail.setError("Cannot be empty");
                    iPassword.setError("Cannot be empty");
                    return;
                }

                iProgressBar.setVisibility(View.GONE);

                iFirebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), SelectActivity.class));

                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
           }
       });
    }
}