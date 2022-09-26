package com.example.easyed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity {
    ImageView loan, scholar, intern, career;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        loan= findViewById(R.id.loanimage);
        scholar = findViewById(R.id.scholarimage);
        intern = findViewById(R.id.internImage);
        career= findViewById(R.id.adviceImage);
        button = findViewById(R.id.logoutbtn);

        loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, MainActivity.class));

            }
        });

        scholar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, MainActivity2Scholarship.class));

            }
        });
        career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, InDevActivity.class));
            }
        });

        intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, InDevActivity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, LoginActivity.class));
            }
        });

    }
}