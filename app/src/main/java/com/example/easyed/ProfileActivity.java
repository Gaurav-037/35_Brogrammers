package com.example.easyed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

       button= findViewById(R.id.logoutbtn);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(ProfileActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
               Intent intent= new Intent(ProfileActivity.this, LoginActivity.class);
               startActivity(intent);
               finish();

           }
       });
    }
}