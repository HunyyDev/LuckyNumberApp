package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LuckyNumberActivity extends AppCompatActivity {

    private Button btnShare;
    private TextView tvLuckyNumber;
    private String userName;
    private int luckyNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);
        initiate();
        if (retrieveDataFromIntent()) {
            String stringCastedLuckyNumber = String.valueOf(luckyNumber);
            tvLuckyNumber.setText(stringCastedLuckyNumber);
        }
    }

    private boolean retrieveDataFromIntent() {
        Intent i = getIntent();
        userName = i.getStringExtra("userName");
        luckyNumber = i.getIntExtra("luckyNumber", 0);
        return true;
    }

    private void initiate() {
        tvLuckyNumber = findViewById(R.id.tvLuckyNumber);
        btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(v -> shareData());
    }

    private void packingData(Intent i) {
        i.setType("text/plain");
        String stringCastedLuckyNumber = String.valueOf(luckyNumber);
        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky number today!");
        i.putExtra(Intent.EXTRA_TEXT, "Lucky number is " + stringCastedLuckyNumber);
    }

    private void shareData() {
        Intent i = new Intent(Intent.ACTION_SEND);
        packingData(i);

        startActivity(Intent.createChooser(i, "Share via"));
    }
}