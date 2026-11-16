package com.example.dwaekrany;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // POPRAW DANE = zamknij ten ekran i wróć do poprzedniego (jak Wstecz)
        findViewById(R.id.btnEdit).setOnClickListener(v -> finish());
    }
}