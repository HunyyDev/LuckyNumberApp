package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnGetLuckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
    }

    private int luckyNumber() {
        int minValue = 0, maxValue = 100;
        Random randomGenerator = new Random();
        int luckyNumber = randomGenerator.nextInt((maxValue - minValue) + 1) + minValue;
        return luckyNumber;
    }

    private void initiate() {
        etName = findViewById(R.id.etName);
        btnGetLuckyNumber = findViewById(R.id.btnGetLuckyNumber);
        btnGetLuckyNumber.setOnClickListener(v -> {
            int generatedLuckyNumber = luckyNumber();
            String userName = etName.getText().toString();

            Intent i = new Intent(getApplicationContext(),LuckyNumberActivity.class);
            i.putExtra("userName",userName);
            i.putExtra("luckyNumber",generatedLuckyNumber);
            startActivity(i);
        });

    }
}