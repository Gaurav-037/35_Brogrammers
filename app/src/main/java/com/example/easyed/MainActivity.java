package com.example.easyed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EditText editText;
    String[] bankNames={"State Bank of India", "Bank of Maharashtra", "Bank of India", "Axis Bank", "ICICI Bank", "Bank of Baroda", "Prerna Bank", "HDFC Bank",
            "Kotak Bank", "Canara Bank"};

    int[] images={R.drawable.sbi, R.drawable.bom, R.drawable.boi, R.drawable.axis, R.drawable.icici, R.drawable.bob,
            R.drawable.sbi, R.drawable.hdfc,R.drawable.kotak,R.drawable.canara};


    private Object recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new recyclerAdapter(this, bankNames, images);
        recyclerView.setAdapter((RecyclerView.Adapter) recyclerAdapter);
    }
}