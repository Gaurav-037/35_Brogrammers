package com.example.easyed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity {
    ImageView loan, scholar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        loan= findViewById(R.id.loanimage);
        scholar = findViewById(R.id.scholarimage);

        loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, MainActivity.class));

            }
        });

        scholar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectActivity.this, MainActivity.class));

            }
        });


    }
}