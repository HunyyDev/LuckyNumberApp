package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LuckyNumberActivity extends AppCompatActivity {

    private Button btnShare;
    private TextView tvLuckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);
        initiate();
    }

    private void initiate() {
        tvLuckyNumber = findViewById(R.id.tvLuckyNumber);
        
        btnShare = findViewById(R.id.btnShare);

    }
}