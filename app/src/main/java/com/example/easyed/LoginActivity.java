package com.example.easyed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                Intent intentTwo= new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentTwo);
            }
        });
    }
}