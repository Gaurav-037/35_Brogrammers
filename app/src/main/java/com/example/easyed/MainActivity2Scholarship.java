package com.example.easyed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity2Scholarship extends AppCompatActivity {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    String[] scholarshipNames={"Scholarships for 10th Pass Students", "Scholarships for 12th Pass students", "Engineering Scholarships",
            "Medical scholarships", "Law Scholarships", "All government scholarships", "All private scholarhsips", "Scholarships for Higher Education",
            "Abroad Scholarships", "Bank fundings"};

    int[] images={R.drawable.idss, R.drawable.idss, R.drawable.idss, R.drawable.idss, R.drawable.idss, R.drawable.idss,
            R.drawable.idss, R.drawable.idss,R.drawable.idss,R.drawable.idss};


    private Object recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_scholarship);

        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new recyclerAdapter(this, scholarshipNames, images);
        recyclerView.setAdapter((RecyclerView.Adapter) recyclerAdapter);
    }
}