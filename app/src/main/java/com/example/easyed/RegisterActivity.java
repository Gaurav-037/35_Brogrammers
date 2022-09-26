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

        button= findViewById(R.id.signInButton);
        textView= findViewById(R.id.textView3);
        rEmail= findViewById(R.id.Lgmail);
        rName= findViewById(R.id.Lname);
        rPassword= findViewById(R.id.Lpassword);
        firebaseAuth= FirebaseAuth.getInstance();



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOne= new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentOne);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email= rEmail.getText().toString().trim();
                String Password= rPassword.getText().toString().trim();
                String Name= rName.getText().toString().trim();
                if (firebaseAuth.getCurrentUser()!=null){
                    Toast.makeText(RegisterActivity.this, "Already used", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                }

                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password) || TextUtils.isEmpty(Name)){
                    rEmail.setError("Cannot be empty");
                    rPassword.setError("Cannot be empty");
                    rName.setError("Cannot be empty");
                    return;
                }



                firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), SelectActivity.class));
                        finish();

                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Error: "+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                    }
                    progressBar.setVisibility(View.GONE);

                    }
                });
            }
        });
    }
}